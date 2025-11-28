<script lang="ts" setup>
import { useTheme } from '@/composables/theme/theme'

const { themeVars, theme } = useTheme()

const route = useRoute()

const navbarTitle = computed(() => route.style!.navigationBarTitleText)

function handleClick(type: 'home' | 'back') {
  switch (type) {
    case 'home':
      uni.reLaunch({ url: '/pages/home' })
      break
    case 'back':
      uni.navigateBack()
      break
  }
}
</script>

<script lang="ts">
export default {
  options: {
    addGlobalClass: true,
    virtualHost: true,
    styleIsolation: 'shared',
  },
}
</script>

<template>
  <wd-config-provider :theme-vars="themeVars" custom-style="min-height: 100vh" :theme="theme">
    <wd-navbar
      :title="navbarTitle" safe-area-inset-top left-arrow placeholder fixed :bordered="false"
    >
      <template #capsule>
        <wd-navbar-capsule @back="handleClick('back')" @back-home="handleClick('home')" />
      </template>
    </wd-navbar>
    <slot />
    <wd-notify />
    <wd-toast />
    <wd-message-box />
    <privacy-popup />
  </wd-config-provider>
</template>
