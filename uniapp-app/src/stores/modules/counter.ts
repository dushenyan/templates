import { defineStore } from 'pinia'

const useCounterStore = defineStore('counter', () => {
  const count = useStorage('count', 0)
  const time = useStorage('time', Date.now())

  watch(count, () => time.value = Date.now())

  function inc() {
    count.value++
  }

  function dec() {
    count.value--
  }

  return {
    time,
    count,
    inc,
    dec,
  }
})

export default useCounterStore
