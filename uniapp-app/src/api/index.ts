import request from '@/api/request'

export const commonRequest = {
  getApi() {
    return request.get<{ name: string }>({
      url: '/todos',
      params: { name: undefined },
    })
  },
}
