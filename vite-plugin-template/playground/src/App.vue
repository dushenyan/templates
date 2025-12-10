<script lang="ts" setup>
import { onMounted, ref } from 'vue'

const message = ref('Hello, world')
const pluginInfo = ref()

onMounted(async () => {
  try {
    // 导入虚拟模块
    // @ts-ignore - TypeScript 无法识别虚拟模块
    const info = await import('virtual:plugin-info')
    pluginInfo.value = info.default
  }
  catch (error) {
    console.error('Failed to load plugin info:', error)
  }
})
</script>

<template>
  <div class="container">
    <header>
      <h1>{{ message }}!</h1>
      <p class="subtitle">
        这个示例展示了 Vite 插件模板的功能
      </p>
    </header>

    <main>
      <section class="demo-section">
        <h2>文本转换演示</h2>
        <p>插件会将 "Hello, world" 替换为 "Hello, vite-plugin-template"</p>
        <div class="code-example">
          <p>原始文本: "Hello, world"</p>
          <p>转换后: "Hello, vite-plugin-template"</p>
        </div>
      </section>

      <section v-if="pluginInfo" class="demo-section">
        <h2>插件信息</h2>
        <div class="plugin-info">
          <p><strong>名称:</strong> {{ pluginInfo.name }}</p>
          <p><strong>版本:</strong> {{ pluginInfo.version }}</p>
          <details>
            <summary>配置选项</summary>
            <pre>{{ JSON.stringify(pluginInfo.options, null, 2) }}</pre>
          </details>
        </div>
      </section>

      <section class="demo-section">
        <h2>功能特性</h2>
        <ul>
          <li>✅ 支持多种文件类型 (.vue, .ts, .js, .tsx, .jsx)</li>
          <li>✅ 可配置的文本替换规则</li>
          <li>✅ 虚拟模块支持</li>
          <li>✅ 开发模式日志输出</li>
          <li>✅ TypeScript 类型支持</li>
          <li>✅ 单元测试覆盖</li>
        </ul>
      </section>
    </main>
  </div>
</template>

<style scoped>
.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 2rem;
  font-family: Arial, sans-serif;
}

header {
  text-align: center;
  margin-bottom: 3rem;
}

h1 {
  color: #42b883;
  margin-bottom: 0.5rem;
}

.subtitle {
  color: #666;
  font-size: 1.1rem;
}

.demo-section {
  margin-bottom: 2rem;
  padding: 1.5rem;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  background-color: #f9f9f9;
}

h2 {
  color: #333;
  margin-bottom: 1rem;
}

.code-example {
  background-color: #f0f0f0;
  padding: 1rem;
  border-radius: 4px;
  font-family: monospace;
  margin-top: 1rem;
}

.plugin-info {
  background-color: #f0f0f0;
  padding: 1rem;
  border-radius: 4px;
}

details {
  margin-top: 1rem;
}

pre {
  background-color: #eee;
  padding: 0.5rem;
  border-radius: 4px;
  overflow-x: auto;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin-bottom: 0.5rem;
}
</style>
