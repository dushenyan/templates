import type { configVO } from './types'
import { un } from '@uni-helper/uni-network'
import { requestInterceptors, responseInterceptors } from './interceptors'

export const config = {
  baseUrl: __VITE_SERVER_BASEURL__,
  headers: { 'X-Custom-Header': 'foobar' },
}

// 创建实例时配置默认值
const instance = un.create({
  ...config,
})

requestInterceptors(instance)
responseInterceptors(instance)

// 工具函数：统一处理请求
function request<T = any>(option: configVO): Promise<T> {
  const { params, data, headersType, ...rest } = option

  return instance.request({
    ...rest,
    params,
    data,
  })
}

function get<T = any>(config: configVO): Promise<T> {
  return request({ ...config, method: 'GET' })
}

function post<T = any>(config: configVO): Promise<T> {
  return request({ ...config, method: 'POST' })
}

function upload<T = any>(config: configVO): Promise<T> {
  return request({ ...config, method: 'POST' })
}

function download<T = any>(config: configVO): Promise<T> {
  return request({ ...config, method: 'GET' })
}

export default {
  get,
  post,
  upload,
  download,
}
