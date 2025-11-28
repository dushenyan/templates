import path from 'node:path'
import process from 'node:process'
import { fileURLToPath, URL } from 'node:url'

import ComponentPlaceholder from '@binbinji/vite-plugin-component-placeholder'
import Uni from '@uni-helper/plugin-uni'
import Components from '@uni-helper/vite-plugin-uni-components'
import { WotResolver } from '@uni-helper/vite-plugin-uni-components/resolvers'
import UniManifest from '@uni-helper/vite-plugin-uni-manifest'
import UniMiddleware from '@uni-helper/vite-plugin-uni-middleware'
import UniPages from '@uni-helper/vite-plugin-uni-pages'
import UniPlatformModifier from '@uni-helper/vite-plugin-uni-platform-modifier'
import UniRoot from '@uni-ku/root'
import { Table } from 'console-table-printer'
import { UniEchartsResolver } from 'uni-echarts/resolver'
import { UniEcharts } from 'uni-echarts/vite'
import UnoCSS from 'unocss/vite'

import { defineConfig, loadEnv } from 'vite'

export default ({ command, mode }) => {
  // pnpm dev:h5 时得到 => serve development
  // pnpm build:h5 时得到 => build production
  // pnpm dev:mp-weixin 时得到 => build development (注意区别，command为build)
  // pnpm build:mp-weixin 时得到 => build production
  // pnpm dev:app 时得到 => build development (注意区别，command为build)
  // pnpm build:app 时得到 => build production
  // dev 和 build 命令可以分别使用 .env.development 和 .env.production 的环境变量

  const { UNI_PLATFORM } = process.env

  const env = loadEnv(mode, path.resolve(process.cwd(), 'env'))
  const {
    VITE_APP_PORT,
    VITE_SERVER_BASEURL,
    VITE_DELETE_CONSOLE,
    VITE_APP_PROXY,
    VITE_APP_PROXY_PREFIX,
  } = env

  // 优化后的表格显示
  const envTable = new Table({
    title: `Environment Variables(${mode})`,
    columns: [
      { name: 'key', alignment: 'left' },
      { name: 'value', alignment: 'left' },
    ],
    colorMap: {
      urgent: '\x1B[31m',
      on_track: '\x1B[32m',
    },
  })

  envTable.addRow({ key: 'UNI_PLATFORM', value: UNI_PLATFORM }, { color: 'urgent' })
  Object.entries(env).forEach(([key, value], index) => {
    envTable.addRow({ key, value }, { color: index % 2 === 1 ? 'urgent' : 'on_track' })
  })

  envTable.printTable()

  return defineConfig({
    envDir: './env', // 自定义env目录

    resolve: {
      alias: {
        '@': fileURLToPath(new URL('./src', import.meta.url)),
      },
    },
    define: {
      __UNI_PLATFORM__: JSON.stringify(UNI_PLATFORM),
      __VITE_APP_PROXY__: JSON.stringify(VITE_APP_PROXY),
    },
    plugins: [
      // https://uni-helper.js.org/vite-plugin-uni-components
      Components({
        dts: true,
        resolvers: [UniEchartsResolver(), WotResolver()],
      }),
      // https://uni-helper.js.org/vite-plugin-uni-pages
      UniPages(),
      // https://uni-helper.js.org/vite-plugin-uni-manifest
      UniManifest(),
      // https://uni-helper.js.org/vite-plugin-uni-platform-modifier
      UniPlatformModifier(),
      // https://uni-helper.js.org/vite-plugin-uni-middleware
      UniMiddleware(),
      // https://github.com/uni-ku/root
      UniRoot(),
      // https://github.com/chouchouji/vite-plugin-component-placeholder
      ComponentPlaceholder(),
      // https://uni-echarts.xiaohe.ink
      UniEcharts(),
      // https://uni-helper.js.org/plugin-uni
      Uni(),
      UnoCSS(),
    ],
    build: {
      target: 'es6',
      cssTarget: 'chrome61',
      sourcemap: false,
      minify: 'terser',
      terserOptions: {
        compress: {
          drop_console: VITE_DELETE_CONSOLE === 'true',
          drop_debugger: true,
        },
      },
    },
    optimizeDeps: {
      exclude: [
        'vue-demi',
        'uni-echarts',
      ],
    },
  })
}
