<script lang="ts" setup>
import { useTheme } from '@/composables/theme/theme'

definePage({
  style: {
    navigationBarTitleText: '设置',
  },
  name: 'setting',
  layout: 'tabbar',
})

const isDark = ref(false)
const { toggleTheme, themeVars, colorColumns } = useTheme()
function change() {
  toggleTheme()
}
</script>

<template>
  <view>
    <wd-cell title="暗黑模式">
      <wd-switch v-model="isDark" @change="change" />
    </wd-cell>
    <wd-select-picker
      v-if="themeVars.colorTheme"
      v-model="themeVars.colorTheme" :show-confirm="false" label="切换颜色"
      :columns="colorColumns" type="radio" :z-index="100"
    />
  </view>
</template>
