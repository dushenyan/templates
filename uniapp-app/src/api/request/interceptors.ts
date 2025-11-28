import type { UnData, UnError, UnInstance, UnResponse } from '@uni-helper/uni-network'
import type { configVO } from './types'
import { getToken } from '@/utils/auth'
import storage from '@/utils/storage'
import { showMessage } from './errorCode'

// 是否正在刷新 token 的标记
let isRefreshing = false
// 重试队列，每一项将是一个待执行的函数形式
let requestQueue: (() => void)[] = []

// 工具函数：防止重复提交
function preventRepeatSubmit(config: configVO): boolean {
  const requestObj = {
    url: config.url,
    data: typeof config.data === 'object' ? JSON.stringify(config.data) : config.data,
    time: new Date().getTime(),
  }
  const sessionObj = storage.getJSON('sessionObj')
  const interval = 1000 // 间隔时间(ms)，小于此时间视为重复提交

  if (sessionObj) {
    const { url: s_url, data: s_data, time: s_time } = sessionObj
    if (s_data === requestObj.data && requestObj.time - s_time < interval && s_url === requestObj.url) {
      const message = '数据正在处理，请勿重复提交'
      console.warn(`[${s_url}]: ${message}`)
      return true
    }
  }

  storage.setJSON('sessionObj', requestObj)
  return false
}

// 工具函数：处理 401 未授权
async function handleUnauthorized(instance: UnInstance, config: configVO): Promise<any> {
  if (!isRefreshing) {
    isRefreshing = true
    try {
      // await useUserStore().authLogin()
      requestQueue.forEach(cb => cb())
      requestQueue = []
      return instance.request(config)
    }
    finally {
      isRefreshing = false
    }
  }
  else {
    return new Promise((resolve) => {
      requestQueue.push(() => resolve(instance.request(config)))
    })
  }
}

// // 请求拦截器
function requestInterceptors(instance: UnInstance) {
  instance.interceptors.request.use(
    (config) => {
      config.data = config.data || {}

      // 是否需要设置 token
      const isToken = config.custom?.auth === false
      if (getToken() && !isToken && config.header) {
        config.header.token = getToken()
      }

      // 防止重复提交
      const isRepeatSubmit = config.custom?.repeatSubmit === false
      if (!isRepeatSubmit && (config.method === 'POST' || config.method === 'PUT')) {
        if (preventRepeatSubmit(config)) {
          return Promise.reject(new Error('数据正在处理，请勿重复提交'))
        }
      }

      return config
    },
    (error: any) => {
      console.error('请求拦截器错误:', error)
      return Promise.reject(error)
    },
  )
}

// // 响应拦截器
function responseInterceptors(instance: UnInstance) {
  instance.interceptors.response.use(
    async (response: UnResponse) => {
      const data = response.data
      if (response.status === 200) {
        return data
      }
      return Promise.reject(new Error('Error'))
      // const config = response.config
      // const custom = config?.custom
      // if (data.code === 200) {
      //   return data || {}
      // }

      // if (data.code === 401) {
      //   return handleUnauthorized(instance, config)
      // }

      // if (custom?.toast !== false) {
      //   Toast(data.message)
      // }

      // if (custom?.catch) {
      //   return Promise.reject(data)
      // }
    },
    (error: UnError) => {
      if (error.code) {
        showMessage(error.code)
        return Promise.reject(error)
      }
      showMessage('网络连接异常,请稍后再试!')
      return Promise.reject(error)
    },
  )
}

export { requestInterceptors, responseInterceptors }
