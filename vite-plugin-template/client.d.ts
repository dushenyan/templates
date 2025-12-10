export interface PluginInfo {
  name: string
  version: string
  options: {
    debug: boolean
    from: string | RegExp
    to: string
    extensions: string[]
    log: boolean
  }
}

declare module 'virtual:plugin-info' {
  const info: PluginInfo
  export default info
}
