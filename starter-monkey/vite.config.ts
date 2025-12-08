import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import monkey, { cdn } from 'vite-plugin-monkey';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    monkey({
      entry: 'src/main.ts',
      userscript: {
        name: 'pkg-name',
        namespace: 'pkg-namespace',
        description: 'pkg-description',
        version: '0.0.1',
        author: 'pkg-author',
        icon: 'https://vitejs.dev/logo.svg',
        match: ['https://target-website.com/*'],
        grant: ['GM_addStyle', 'GM_getValue', 'GM_setValue'],
      },
      build: {
        externalGlobals: {
          vue: cdn.jsdelivr('Vue', 'dist/vue.global.prod.js'),
        },
      },
    }),
  ],
});
