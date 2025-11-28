import { computed, ref, watch } from 'vue'

export function useTheme() {
  const isDarkMode = ref(false)

  // 应用主题到文档和 Arco Design
  const applyTheme = () => {
    const root = document.documentElement
    const body = document.body

    if (isDarkMode.value) {
      root.classList.add('arco-theme-dark')
      root.setAttribute('arco-theme', 'dark')
      body.classList.add('arco-theme-dark')
    }
    else {
      root.classList.remove('arco-theme-dark')
      root.setAttribute('arco-theme', 'light')
      body.classList.remove('arco-theme-dark')
    }

    // 保存到本地存储
    localStorage.setItem('theme', isDarkMode.value ? 'dark' : 'light')
  }

  // 初始化主题
  const initTheme = () => {
    // 从本地存储获取主题设置，或使用系统偏好
    const savedTheme = localStorage.getItem('theme')
    if (savedTheme) {
      isDarkMode.value = savedTheme === 'dark'
    }
    else {
      isDarkMode.value = window.matchMedia('(prefers-color-scheme: dark)').matches
    }
    applyTheme()
  }

  // 切换主题
  const toggleTheme = () => {
    isDarkMode.value = !isDarkMode.value
    applyTheme()
  }

  // 计算当前主题配置
  const themeConfig = computed(() => {
    const darkTheme = {
      // 基础颜色
      colorBgLayout: '#000000',
      colorBgContainer: '#1C1C1E',
      colorBgElevated: '#2C2C2E',
      colorBgSpotlight: '#38383A',

      // 文本颜色
      colorText: '#FFFFFF',
      colorTextSecondary: '#999999',
      colorTextTertiary: '#666666',
      colorTextQuaternary: '#48484A',

      // 边框颜色
      colorBorder: '#2C2C2E',
      colorBorderSecondary: '#38383A',

      // 主色调
      colorPrimary: '#0A84FF',
      colorPrimaryHover: '#409CFF',
      colorPrimaryActive: '#0077E6',

      // 其他颜色
      colorSuccess: '#30D158',
      colorWarning: '#FF9F0A',
      colorError: '#FF453A',
      colorInfo: '#64D2FF',
    }

    const lightTheme = {
      // 基础颜色
      colorBgLayout: '#F2F2F7',
      colorBgContainer: '#FFFFFF',
      colorBgElevated: '#FFFFFF',
      colorBgSpotlight: '#F9F9F9',

      // 文本颜色
      colorText: '#000000',
      colorTextSecondary: '#666666',
      colorTextTertiary: '#999999',
      colorTextQuaternary: '#CCCCCC',

      // 边框颜色
      colorBorder: '#E5E5EA',
      colorBorderSecondary: '#F2F2F7',

      // 主色调
      colorPrimary: '#007AFF',
      colorPrimaryHover: '#3395FF',
      colorPrimaryActive: '#0066CC',

      // 其他颜色
      colorSuccess: '#34C759',
      colorWarning: '#FF9500',
      colorError: '#FF3B30',
      colorInfo: '#5AC8FA',
    }

    return {
      token: isDarkMode.value ? darkTheme : lightTheme,
      // Arco Design 支持的主题算法
      algorithm: isDarkMode.value ? 'dark' : 'light',
    }
  })

  // 监听主题变化
  watch(isDarkMode, applyTheme)

  return {
    isDarkMode,
    themeConfig,
    toggleTheme,
    initTheme,
  }
}
