<script setup>
const arrayBuffer = new Uint8Array([55, 55, 55])
const base64 = uni.arrayBufferToBase64(arrayBuffer)
console.log('base64', base64)
console.log('getSystemInfo', await uni.getSystemInfo())
</script>

<template>
  <view class="center">
    获取手机号
  </view>
</template>
