<script setup lang="ts">
import { commonRequest } from '@/api/index'

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

<route lang="json">
{
  "layout": "tabbar",
  "name": "hi",
  "style": {
    "navigationBarTitleText": "hi"
  }
}
</route>
