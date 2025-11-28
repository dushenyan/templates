import { defineUniPages } from '@uni-helper/vite-plugin-uni-pages'

export default defineUniPages({
  easycom: {
    autoscan: true,
    custom: {
      '^uni-(.*)': '@dcloudio/uni-ui/lib/uni-$1/uni-$1.vue',
      '^(?!z-paging-refresh|z-paging-load-more)z-paging(.*)': 'z-paging/components/z-paging$1/z-paging$1.vue',
    },
  },
  pages: [],
  globalStyle: {
    backgroundColor: '@bgColor',
    backgroundColorBottom: '@bgColorBottom',
    backgroundColorTop: '@bgColorTop',
    backgroundTextStyle: '@bgTxtStyle',
    navigationBarBackgroundColor: '#000000',
    navigationBarTextStyle: '@navTxtStyle',
    navigationBarTitleText: 'Uni Creator',
    navigationStyle: 'custom',
  },
  tabBar: {
    custom: true,
    height: '0',
    color: '#bfbfbf',
    selectedColor: '#0165FF',
    list: [
      {
        pagePath: 'pages/home',
      },
      {
        pagePath: 'pages/playground',
      },
      {
        pagePath: 'pages/setting',
      },
      {
        pagePath: 'pages/user',
      },
    ],
  },
})
