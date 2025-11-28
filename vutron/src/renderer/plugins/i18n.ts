import { createI18n } from 'vue-i18n'
import en from '@/renderer/locales/en.json'
import zhHans from '@/renderer/locales/zh-hans.json'
import zhHant from '@/renderer/locales/zh-hant.json'
import { getCurrentLocale } from '@/renderer/utils'

export default createI18n({
  locale: getCurrentLocale(),
  fallbackLocale: 'en',
  globalInjection: true,
  messages: {
    en,
    zh: zhHans,
    zhHant,
  },
})
