import { createApp } from 'vue'
import App from './App.vue'

// 这也是一个示例，插件可以处理这里的文本
// "Hello, world" 会被替换为 "Hello, vite-plugin-template"
const app = createApp(App)

app.mount('#app')
