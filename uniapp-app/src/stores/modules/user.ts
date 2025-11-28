import { defineStore } from 'pinia'

const useUserStore = defineStore(
  'user',
  () => {
    const userInfo = ref({})

    const token = ref('123')

    async function login() {
      const res = await Promise.resolve({
        token: '123',
      })

      token.value = res.token
    }

    function logout() {
      token.value = ''
    }

    async function getUserData() {
      const res = await Promise.resolve({
        data: {
          name: 'vben',
          age: 18,
        },
      })

      userInfo.value = res.data
    }

    return {
      token,
      userInfo,
      login,
      logout,
      getUserData,
    }
  },
)

export default useUserStore
