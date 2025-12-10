import type { Plugin } from 'vite'
import { createPluginName, createVirtualModuleID } from './shared/create'

interface PluginOptions {
  /**
   * 是否启用调试模式
   * @default false
   */
  debug?: boolean

  /**
   * 要替换的文本模式
   * @default 'Hello, world'
   */
  from?: string | RegExp

  /**
   * 替换后的文本
   * @default 'Hello, vite-plugin-template'
   */
  to?: string

  /**
   * 要处理的文件扩展名
   * @default ['.vue', '.ts', '.js', '.tsx', '.jsx']
   */
  extensions?: string[]

  /**
   * 是否在控制台输出转换信息
   * @default true
   */
  log?: boolean
}

const DEFAULT_OPTIONS: Required<PluginOptions> = {
  debug: false,
  from: 'Hello, world',
  to: 'Hello, vite-plugin-template',
  extensions: ['.vue', '.ts', '.js', '.tsx', '.jsx'],
  log: true,
}

const useName = createPluginName(false)

function createPlugin(options: PluginOptions = {}): Plugin {
  const resolvedOptions = { ...DEFAULT_OPTIONS, ...options }

  if (resolvedOptions.debug) {
    console.log(`[${useName('template')}] Plugin options:`, resolvedOptions)
  }

  return {
    name: useName('template'),
    enforce: 'pre',

    transform(code, id) {
      const cleanId = id.split('?')[0]
      const extension = cleanId.split('.').pop()

      // 检查文件扩展名是否在处理列表中
      if (!extension || !resolvedOptions.extensions.includes(`.${extension}`)) {
        return null
      }

      let transformedCode = code

      // 执行文本替换
      if (typeof resolvedOptions.from === 'string') {
        transformedCode = transformedCode.replace(
          new RegExp(resolvedOptions.from, 'g'),
          resolvedOptions.to,
        )
      }
      else {
        transformedCode = transformedCode.replace(resolvedOptions.from, resolvedOptions.to)
      }

      // 如果代码发生了变化，输出日志
      if (transformedCode !== code && resolvedOptions.log) {
        console.log(
          `[${useName('template')}] Transformed: ${cleanId}`,
        )
      }

      return transformedCode === code ? null : transformedCode
    },

    // 插供虚拟模块
    resolveId(id) {
      const { virtualModuleId, resolvedVirtualModuleId } = createVirtualModuleID('plugin-info')
      return id === virtualModuleId ? resolvedVirtualModuleId : null
    },

    load(id) {
      const { resolvedVirtualModuleId } = createVirtualModuleID('plugin-info')
      if (id === resolvedVirtualModuleId) {
        return `export default ${JSON.stringify({
          name: useName('template'),
          version: '1.0.0',
          options: resolvedOptions,
        })}`
      }
      return null
    },
  }
}

export default createPlugin

// 导出类型以供外部使用
export type { PluginOptions }
