<script setup lang="ts">
import { useTheme } from '@/composables/theme/theme'

const { themeVars, theme } = useTheme()

definePage({
  style: {
    navigationBarTitleText: '主页',
  },
  name: 'home',
  layout: 'tabbar',
})
</script>

<template>
  <view>
    <wd-cell title="当前暗黑模式">
      <view>{{ theme }}</view>
    </wd-cell>
    <wd-cell title="当前主题色">
      <view class="inline-block h-4 w-4 rounded" :style="{ 'background-color': themeVars.colorTheme }" />
    </wd-cell>
  </view>
</template>

<style></style>
