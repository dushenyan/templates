// 如果第三方包偷懒没有ts版本，就需要进行以下设置
declare module 'vue3-scroll-seamless' {
  // eslint-disable-next-line ts/no-use-before-define
  export { vue3ScrollSeamless }
}
declare module 'vue3-odometer' {
  // eslint-disable-next-line ts/no-use-before-define
  export { Vue3Odometer }
}
