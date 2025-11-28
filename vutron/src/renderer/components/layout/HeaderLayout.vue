<script setup lang="tsx">
import { IconApps, IconHome } from '@arco-design/web-vue/es/icon'
import { onMounted, ref } from 'vue'
import { useI18n } from 'vue-i18n'
import { useRoute, useRouter } from 'vue-router'

const router = useRouter()
const route: any = useRoute()
const titleKey: string = (route?.meta?.titleKey || 'title.main') as string

const { t } = useI18n()

function handleRoute(path: string): void {
  router.push(path)
}

function isCurrentRoute(path: string): boolean {
  return path === route.path
}

const headerMenus: {
  icon: any
  text: string
  path: string
}[] = [
  {
    icon: IconHome,
    text: 'title.main',
    path: '/',
  },
  {
    icon: IconApps,
    text: 'title.second',
    path: '/second',
  },
]

const { locale, availableLocales } = useI18n()

const languages = ref(['en'])

function handleChangeLanguage(val: string): void {
  locale.value = val
}

onMounted((): void => {
  languages.value = availableLocales
})
</script>

<template>
  <a-layout-header class="mac-header">
    <div class="header-content">
      <h1 class="header-title">
        {{ t(titleKey) }}
      </h1>
      <div class="header-nav">
        <a-select
          data-testid="select-language" :style="{ width: '120px' }" :model-value="locale" :placeholder="t('menu.change-language')"
          :options="languages.map(lang => ({ label: lang, value: lang }))" class="mac-select"
          @change="handleChangeLanguage"
        />
        <a-button
          v-for="menu in headerMenus" :key="menu.path" type="text"
          :class="{ 'mac-active': isCurrentRoute(menu.path) }" class="mac-nav-btn" @click="handleRoute(menu.path)"
        >
          <template #icon>
            <component :is="menu.icon" />
          </template>
          {{ t(menu.text) }}
        </a-button>
      </div>
    </div>
  </a-layout-header>
</template>

<style scoped>
.mac-header {
  background: linear-gradient(135deg, #007AFF 0%, #5856D6 100%);
  border-bottom: 1px solid rgba(255, 255, 255, 0.1);
  backdrop-filter: blur(20px);
  -webkit-backdrop-filter: blur(20px);
  padding: 0;
  height: 60px;
  line-height: 60px;
  transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
}

/* 暗色主题下的导航栏 */
.arco-theme-dark .mac-header {
  background: linear-gradient(135deg, #0A84FF 0%, #5E5CE6 100%);
  border-bottom: 1px solid rgba(255, 255, 255, 0.15);
}

.header-content {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 24px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 100%;
}

.header-title {
  color: white;
  font-size: 18px;
  font-weight: 600;
  margin: 0;
  letter-spacing: 0.01em;
}

.header-nav {
  display: flex;
  gap: 8px;
}

.language-select {
  max-width: 300px;
  margin: 0 auto;
}

.mac-select {
  border-radius: 12px;
}

.mac-nav-btn {
  opacity: 0.8;
  color: rgba(255, 255, 255, 0.9) !important;
  font-weight: 500;
  letter-spacing: 0.01em;
  border-radius: 8px;
  transition: all 0.2s cubic-bezier(0.4, 0, 0.2, 1);
  border: 1px solid transparent;
}

.mac-nav-btn:hover {
  opacity: 1;
  background-color: rgba(255, 255, 255, 0.15);
  border-color: rgba(255, 255, 255, 0.2);
}

.mac-nav-btn.mac-active {
  opacity: 1 !important;
  background-color: rgba(255, 255, 255, 0.2) !important;
  border-color: rgba(255, 255, 255, 0.3) !important;
  font-weight: 600 !important;
}

/* Responsive adjustments */
@media (max-width: 768px) {
  .header-content {
    padding: 0 16px;
  }

  .header-title {
    font-size: 16px;
  }

  .mac-nav-btn {
    padding: 4px 8px;
    font-size: 14px;
  }
}
</style>
