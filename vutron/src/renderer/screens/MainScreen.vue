<script setup lang="tsx">
import {
  IconFile,
  IconFolder,
  IconGithub,
  IconMoon,
  IconPlus,
  IconSun,
} from '@arco-design/web-vue/es/icon'
import { storeToRefs } from 'pinia'
import { onMounted, ref } from 'vue'
import { useI18n } from 'vue-i18n'

import { useTheme } from '@/renderer/composables/useTheme'
import { useCounterStore } from '@/renderer/store/counter'
import { openExternal, openFile } from '@/renderer/utils'

const { t, availableLocales } = useI18n()
const { increaseCount } = useCounterStore()
const { count } = storeToRefs(useCounterStore())
const { isDarkMode, toggleTheme } = useTheme()

const languages = ref(['en'])
const appVersion = ref('Unknown')
const selectedFile = ref('')

onMounted((): void => {
  languages.value = availableLocales

  // Get application version from package.json version string (Using IPC communication)
  getApplicationVersionFromMainProcess()
})

function getApplicationVersionFromMainProcess(): void {
  window.mainApi.invoke('msgRequestGetVersion').then((result: string) => {
    appVersion.value = result
  })
}

function handleChangeTheme(): void {
  toggleTheme()
}

async function handleOpenDocument(): Promise<void> {
  await openExternal('https://vutron.cdget.com')
}

async function handleOpenGitHub(): Promise<void> {
  await openExternal('https://github.com/jooy2/vutron')
}

function handleCountIncrease(): void {
  increaseCount(1)
}

async function handleOpenFile() {
  const dialogResult = await openFile('text')
  if (!dialogResult.canceled) {
    selectedFile.value = dialogResult.filePaths[0]
  }
}
</script>

<template>
  <div class="mac-container">
    <a-row :gutter="24" class="main-row" align="center">
      <a-col :span="24" :md="24">
        <a-card class="mac-content-card" :bordered="false">
          <h2 class="mac-title">
            {{ t('desc.welcome-title') }}
          </h2>
          <p class="mac-description">
            {{ t('desc.welcome-desc') }}
          </p>
          <a-divider class="mac-divider" />
          <div class="version-info">
            App Version:
            <a-tag color="blue" size="small">
              {{ appVersion }}
            </a-tag>
          </div>
          <p v-if="selectedFile" class="selected-file-info">
            {{
              t('desc.selected-file', {
                filePath: selectedFile,
              })
            }}
          </p>

          <div class="action-buttons">
            <a-button type="primary" size="large" class="mac-action-btn" @click="handleChangeTheme">
              <template #icon>
                <IconMoon v-if="isDarkMode" />
                <IconSun v-else />
              </template>
              {{ t('menu.change-theme') }}
            </a-button>

            <a-badge :count="count" :offset="[8, 8]" class="counter-badge">
              <a-button
                data-testid="btn-counter" type="primary" size="large" class="mac-action-btn"
                @click="handleCountIncrease"
              >
                <template #icon>
                  <IconPlus />
                </template>
                {{ t('menu.increase-count') }}
              </a-button>
            </a-badge>
          </div>

          <div class="secondary-buttons">
            <a-button type="outline" size="large" class="mac-secondary-btn" @click="handleOpenDocument">
              <template #icon>
                <IconFile />
              </template>
              {{ t('menu.documentation') }}
            </a-button>
            <a-button type="outline" size="large" class="mac-secondary-btn" @click="handleOpenGitHub">
              <template #icon>
                <IconGithub />
              </template>
              {{ t('menu.github') }}
            </a-button>
            <a-button type="outline" size="large" class="mac-secondary-btn" @click="handleOpenFile">
              <template #icon>
                <IconFolder />
              </template>
              {{ t('menu.open-file') }}
            </a-button>
          </div>
        </a-card>
      </a-col>
    </a-row>
  </div>
</template>

<style scoped>
.mac-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px 20px;
}

.main-row {
  min-height: 70vh;
  align-items: center;
}

.mac-logo-card {
  border-radius: 16px;
  overflow: hidden;
  transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
  border: 1px solid rgba(255, 255, 255, 0.2);
  backdrop-filter: blur(20px);
  -webkit-backdrop-filter: blur(20px);
}

.mac-logo-card:hover {
  transform: translateY(-4px);
  box-shadow: 0 12px 24px rgba(0, 0, 0, 0.15);
}

.mac-logo {
  width: 100%;
  height: auto;
  display: block;
}

.mac-content-card {
  border-radius: 16px;
  backdrop-filter: blur(20px);
  -webkit-backdrop-filter: blur(20px);
  border: 1px solid rgba(255, 255, 255, 0.18);
  background: rgba(255, 255, 255, 0.8);
  padding: 24px;
}

@media (prefers-color-scheme: dark) {
  .mac-content-card {
    border: 1px solid rgba(255, 255, 255, 0.08);
    background: rgba(30, 30, 30, 0.8);
  }
}

.mac-title {
  font-size: 2rem;
  font-weight: 700;
  margin-bottom: 16px;
  background: linear-gradient(135deg, #007AFF 0%, #5856D6 100%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

@media (prefers-color-scheme: dark) {
  .mac-title {
    background: linear-gradient(135deg, #0A84FF 0%, #5E5CE6 100%);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    background-clip: text;
  }
}

.mac-description {
  font-size: 1.1rem;
  color: #333;
  margin-bottom: 24px;
  line-height: 1.6;
}

@media (prefers-color-scheme: dark) {
  .mac-description {
    color: #e0e0e0;
  }
}

.mac-divider {
  margin: 24px 0;
  border-color: rgba(0, 0, 0, 0.1);
}

@media (prefers-color-scheme: dark) {
  .mac-divider {
    border-color: rgba(255, 255, 255, 0.1);
  }
}

.version-info {
  font-size: 0.9rem;
  margin-bottom: 16px;
  color: #666;
}

@media (prefers-color-scheme: dark) {
  .version-info {
    color: #aaa;
  }
}

.selected-file-info {
  font-size: 0.9rem;
  margin-bottom: 24px;
  color: #666;
  word-break: break-all;
}

@media (prefers-color-scheme: dark) {
  .selected-file-info {
    color: #aaa;
  }
}

.action-buttons {
  display: flex;
  gap: 16px;
  margin: 32px 0 24px;
  flex-wrap: wrap;
  justify-content: center;
}

.mac-action-btn {
  border-radius: 12px;
  font-weight: 600;
  letter-spacing: 0.01em;
  min-width: 160px;
  height: 48px;
  transition: all 0.2s cubic-bezier(0.4, 0, 0.2, 1);
  border: none;
}

.mac-action-btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 8px 16px rgba(0, 122, 255, 0.3);
}

@media (prefers-color-scheme: dark) {
  .mac-action-btn:hover {
    box-shadow: 0 8px 16px rgba(10, 132, 255, 0.4);
  }
}

.secondary-buttons {
  display: flex;
  gap: 12px;
  margin-bottom: 32px;
  flex-wrap: wrap;
  justify-content: center;
}

.mac-secondary-btn {
  border-radius: 12px;
  font-weight: 500;
  letter-spacing: 0.01em;
  min-width: 140px;
  height: 44px;
  transition: all 0.2s cubic-bezier(0.4, 0, 0.2, 1);
  border-color: #5856D6;
  color: #5856D6;
}

.mac-secondary-btn:hover {
  transform: translateY(-1px);
  border-color: #007AFF;
  color: #007AFF;
  box-shadow: 0 4px 12px rgba(88, 86, 214, 0.25);
}

@media (prefers-color-scheme: dark) {
  .mac-secondary-btn:hover {
    box-shadow: 0 4px 12px rgba(94, 92, 230, 0.35);
  }
}

.mac-select :deep(.arco-select-view) {
  border-radius: 12px;
  height: 44px;
  border-color: rgba(0, 0, 0, 0.2);
}

@media (prefers-color-scheme: dark) {
  .mac-select :deep(.arco-select-view) {
    border-color: rgba(255, 255, 255, 0.2);
    background: rgba(255, 255, 255, 0.05);
  }
}

/* Responsive adjustments */
@media (max-width: 768px) {
  .mac-container {
    padding: 20px 16px;
  }

  .mac-title {
    font-size: 1.5rem;
  }

  .mac-description {
    font-size: 1rem;
  }

  .action-buttons,
  .secondary-buttons {
    justify-content: stretch;
  }

  .mac-action-btn,
  .mac-secondary-btn {
    flex: 1;
    min-width: 120px;
    font-size: 14px;
  }
}

@media (max-width: 480px) {
  .action-buttons {
    flex-direction: column;
  }

  .mac-action-btn,
  .mac-secondary-btn {
    width: 100%;
  }
}
</style>
