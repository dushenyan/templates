<script setup lang="ts">
import { commonRequest } from '@/api/index'

definePage({
  style: {
    navigationBarTitleText: 'hi',
  },
})

const name = ref('')
const router = useRouter()

function goToSub() {
  router.push(`/pages-sub/index?name=${name.value}`)
}
function doubleClick() {
  commonRequest.getApi().then((res) => {
    console.log(res)
  })
}
</script>

<template>
  <div class="center flex-col">
    <wd-button @click="doubleClick">
      请求接口
    </wd-button>
  </div>
</template>
