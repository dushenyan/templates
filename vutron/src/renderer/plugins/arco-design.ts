import type { createApp } from 'vue'
import ArcoVue from '@arco-design/web-vue'
import ArcoVueIcon from '@arco-design/web-vue/es/icon'
import de from '@arco-design/web-vue/es/locale/lang/de-de'
import en from '@arco-design/web-vue/es/locale/lang/en-us'
import es from '@arco-design/web-vue/es/locale/lang/es-es'
import fr from '@arco-design/web-vue/es/locale/lang/fr-fr'
import ja from '@arco-design/web-vue/es/locale/lang/ja-jp'
import ko from '@arco-design/web-vue/es/locale/lang/ko-kr'
import pt from '@arco-design/web-vue/es/locale/lang/pt-pt'
import ru from '@arco-design/web-vue/es/locale/lang/ru-ru'
import zhCN from '@arco-design/web-vue/es/locale/lang/zh-cn'
import zhTW from '@arco-design/web-vue/es/locale/lang/zh-tw'

import '@arco-design/web-vue/dist/arco.css'

const locales = {
  en,
  'zh-Hans': zhCN,
  'zh-Hant': zhTW,
  ja,
  ko,
  de,
  es,
  fr,
  ru,
  pt,
}

export function createArcoDesign(locale: string = 'en') {
  return {
    install(app: ReturnType<typeof createApp>) {
      app.use(ArcoVue)
      app.use(ArcoVueIcon)
    },
    locale: locales[locale as keyof typeof locales] || en,
  }
}

export default createArcoDesign()
