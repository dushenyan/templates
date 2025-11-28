/// <reference types="vite/client" />

declare const __UNI_PLATFORM__: string
declare const __VITE_SERVER_BASEURL__: string
declare const __VITE_UPLOAD_BASEURL__: string

declare global {
  interface ImportMeta {
    readonly env: ImportMetaEnv
  }
}

interface ImportMetaEnv {
  /** 平台 */
  readonly UNI_PLATFORM: string
  /** 端口 */
  readonly VITE_APP_PORT: string
  /** 后台接口地址 */
  readonly VITE_SERVER_BASEURL: string
  /** 上传文件地址 */
  readonly VITE_UPLOAD_BASEURL: string
  /** 代理地址 */
  readonly VITE_APP_PROXY: string
  /** 代理前缀 */
  readonly VITE_APP_PROXY_PREFIX: string
  /** 是否删除console */
  readonly VITE_DELETE_CONSOLE: string
  /** 是否开启sourcemap */
  readonly VITE_SHOW_SOURCEMAP: string
}

interface ImportMeta {
  readonly env: ImportMetaEnv
}
