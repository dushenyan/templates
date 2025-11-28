# Vuetify 到 Arco Design Vue 迁移指南

## 概述

本项目已成功从 Vuetify 迁移到 Arco Design Vue，并采用了 macOS 风格的设计系统。

## 主要变更

### 1. 依赖更新

**移除的依赖：**
- `vuetify` - Vuetify UI 库
- `vite-plugin-vuetify` - Vite Vuetify 插件
- `@mdi/js` - Material Design Icons

**新增的依赖：**
- `@arco-design/web-vue` - Arco Design Vue UI 库

### 2. 配置文件更新

#### `vite.config.mts`
- 移除了 `vite-plugin-vuetify` 配置
- 清理了相关的构建配置

#### `src/renderer/main.ts`
- 移除了 Vuetify 插件导入
- 添加了 Arco Design 配置

### 3. 组件迁移

#### 新建 `src/renderer/plugins/arco-design.ts`
- 创建了 Arco Design 的配置文件
- 支持多语言配置（中文、英文、日文等）
- 移除了原有的 `vuetify.ts` 配置文件

#### `src/renderer/App.vue`
- 更新了全局样式，适配 Arco Design
- 保持了 macOS 风格的设计系统

#### 布局组件更新

**`src/renderer/components/layout/DefaultLayout.vue`**
- 从 `v-app`、`v-layout`、`v-main` 迁移到原生 HTML 标签和 Arco Design
- 保持了响应式布局和主题适配

**`src/renderer/components/layout/HeaderLayout.vue`**
- 从 `v-app-bar` 迁移到 `a-layout-header`
- 更新了导航按钮使用 `a-button` 组件
- 保持了 macOS 风格的渐变背景和交互效果

#### 页面组件更新

**`src/renderer/screens/MainScreen.vue`**
- 完整重写了主要页面组件
- 从 Vuetify 组件映射到 Arco Design 组件：
  - `v-container` → 自定义容器
  - `v-row/v-col` → `a-row/a-col`
  - `v-card` → `a-card`
  - `v-btn` → `a-button`
  - `v-badge` → `a-badge`
  - `v-chip` → `a-tag`
  - `v-select` → `a-select`
  - `v-icon` → Arco Design 图标组件

**`src/renderer/screens/SecondScreen.vue`**
- 迁移了图标组件和日期选择器
- 使用 `IconSmile` 替代 Material Design 图标

**`src/renderer/screens/ErrorScreen.vue`**
- 使用 `a-result` 组件提供更好的错误页面体验

### 4. 样式系统更新

#### `src/renderer/styles/mac-style.css`
- 完全重写了样式系统以适配 Arco Design
- 保持了 macOS 设计语言：
  - 颜色系统：使用 macOS 系统颜色
  - 字体：SF Pro Display 系统字体栈
  - 圆角：12-16px 大圆角设计
  - 阴影：柔和的多层阴影效果
  - 过渡：流畅的 cubic-bezier 动画

## 设计特色

### macOS 风格
- **颜色系统**：采用 macOS 官方色彩规范
- **字体排版**：使用系统字体栈，确保最佳可读性
- **圆角设计**：大圆角元素，符合现代 macOS 设计趋势
- **毛玻璃效果**：使用 backdrop-filter 实现模糊背景
- **渐变背景**：导航栏使用蓝色到紫色的渐变

### 响应式设计
- 移动端适配：在小屏幕上调整布局和按钮大小
- 触摸友好：按钮大小适合触摸操作
- 自适应网格：在不同屏幕尺寸下保持良好布局

### 交互体验
- **微动画**：按钮悬停、点击时的细腻动画效果
- **主题切换**：支持明暗主题自动切换
- **焦点状态**：清晰的焦点指示器
- **加载状态**：优雅的加载过渡效果

## 使用指南

### 新增组件
所有组件现在都使用 Arco Design 的组件，遵循以下规范：

```vue
<!-- 按钮 -->
<a-button type="primary" size="large">
  <template #icon>
    <IconPlus />
  </template>
  按钮
</a-button>

<!-- 卡片 -->
<a-card :bordered="false" class="mac-content-card">
  内容
</a-card>

<!-- 标签 -->
<a-tag color="blue" size="small">标签</a-tag>
```

### 样式类名
所有 macOS 风格的样式类都以 `mac-` 为前缀，便于识别和维护。

### 图标
使用 Arco Design 的图标系统，从 `@arco-design/web-vue/es/icon` 导入。

## 注意事项

1. **破坏性变更**：所有 Vuetify 相关的 API 已被移除
2. **主题系统**：从 Vuetify 的主题系统迁移到 CSS 自定义属性
3. **表单验证**：如需表单验证，请使用 Arco Design 的表单验证系统
4. **国际化**：继续保持使用 Vue I18n，Arco Design 支持多语言

## 后续优化建议

1. **按需加载**：考虑使用 `@arco-plugins/vite-vue` 实现样式的按需加载
2. **主题定制**：可以进一步扩展主题系统，支持更多颜色方案
3. **组件库**：基于 Arco Design 创建项目专用的组件库
4. **测试覆盖**：更新单元测试以适配新的组件

## 兼容性

- Vue 3.5+
- TypeScript 5.9+
- Vite 7.2+
- Electron 39+

迁移完成后的项目保持了所有原有功能，同时提供了更现代、更符合 macOS 设计语言的用户界面。