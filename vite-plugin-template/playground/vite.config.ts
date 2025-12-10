import Vue from '@vitejs/plugin-vue'
import { defineConfig } from 'vite'
import Inspect from 'vite-plugin-inspect'
import VitePluginTemplate from '../src'

export default defineConfig({
  plugins: [
    Vue(),
    Inspect(),
    VitePluginTemplate({
      // 插件配置选项
      debug: true, // 启用调试模式，在控制台输出详细信息
      from: 'Hello, world', // 要替换的文本模式
      to: 'Hello, vite-plugin-template', // 替换后的文本
      extensions: ['.vue', '.ts', '.js'], // 要处理的文件扩展名
      log: true, // 在控制台输出转换信息
    }),
  ],
})
