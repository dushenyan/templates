<script setup lang="ts">
function handleClickGithub() {
  if (window?.open) {
    window.open('https://github.com/uni-ku/root')
  }
  else {
    uni.showToast({
      icon: 'none',
      title: '请使用浏览器打开',
    })
  }
}
</script>

<template>
  <div>
    <KuRootView />
  </div>
</template>

<style lang="scss">
@import './styles/index.css';
</style>
