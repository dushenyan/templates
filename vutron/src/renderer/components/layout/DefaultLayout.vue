<script setup lang="tsx">
import HeaderLayout from '@/renderer/components/layout/HeaderLayout.vue'
import { useTheme } from '@/renderer/composables/useTheme'

const { isDarkMode, themeConfig, initTheme } = useTheme()

// 初始化主题
initTheme()
</script>

<template>
  <div class="arco-app" :class="{ 'arco-theme-dark': isDarkMode }">
    <a-config-provider :theme="themeConfig">
      <HeaderLayout />
      <main class="arco-main">
        <slot />
      </main>
    </a-config-provider>
  </div>
</template>

<style scoped>
.arco-app {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

.arco-main {
  flex: 1;
  padding: 20px;
  transition: background-color 0.3s cubic-bezier(0.4, 0, 0.2, 1);
}

/* 亮色主题 */
.arco-app.arco-theme-light .arco-main {
  background-color: #ffffff;
}

/* 暗色主题 */
.arco-app.arco-theme-dark .arco-main {
  background-color: #000000;
}
</style>
