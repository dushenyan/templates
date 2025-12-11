# Emphasis 模板项目集合

这个仓库包含了多个前端项目模板，用于快速初始化不同类型的项目。所有模板都统一使用 `@antfu/eslint-config` 作为代码格式化工具，确保代码风格的一致性。

<div style="display: none;">
  <title>templates</title>
  <description>项目模板集合，包含多种技术栈的启动模板</description>
  <repository>https://github.com/dushenyan/templates</repository>
</div>

## 🚀 快速开始

### 选择合适的模板

| 模板名称 | 描述 | 技术栈 | 适用场景 |
|---------|------|--------|----------|
| `data-screen-template` | 数据大屏模板 | Vue 3 + TypeScript + Vite | 数据可视化、监控面板 |
| `geeker-admin` | 管理系统模板 | Vue 3 + TypeScript + Vite + Element Plus | 后台管理系统、CRUD应用 |
| `uniapp-template` | 实用型uni-app模板 | Vue 3 + TypeScript + UniApp | 多端应用开发（小程序/H5/APP） |
| `uniapp-app` | 标准uni-app模板 | Vue 3 + TypeScript + UniApp | 小程序、H5应用 |
| `uniapp-lit` | 轻量uni-app模板 | Vue 3 + TypeScript + UniApp | 简单的跨端应用 |
| `starter-monkey` | 油猴插件模板 | Vue 3 + TypeScript + Vite | 浏览器脚本开发 |
| `starter-vscode` | VS Code扩展模板 | Vue 3 + TypeScript + reactive-vscode | VS Code插件开发 |
| `vite-plugin-template` | Vite插件模板 | TypeScript + Vite | Vite插件开发 |
| `vutron` | Electron模板 | Vue 3 + TypeScript + Electron | 桌面应用开发 |
| `vitesse-lite` | 轻量Vue模板 | Vue 3 + TypeScript | 现代Web应用 |
| `starter-ts` | TypeScript库模板 | TypeScript | Node.js库开发 |

### 使用模板

1. **克隆模板**
   ```bash
   git clone <模板仓库地址> my-project
   cd my-project
   ```

2. **修改package.json**
   ```bash
   # 将所有 "pkg-name" 替换为你的项目名
   # 修改描述、作者信息等
   ```

3. **安装依赖**
   ```bash
   pnpm install
   ```

4. **启动开发服务器**
   ```bash
   pnpm dev
   ```

## 🔧 代码规范

### ESLint配置

所有模板都使用 `@antfu/eslint-config` 作为统一的代码格式化工具：

- **自动格式化**: `pnpm lint:fix`
- **代码检查**: `pnpm lint`
- **可视化界面**: `pnpm lint:ui`

### VS Code配置

推荐在项目根目录创建 `.vscode/settings.json`：

```json
{
  "editor.formatOnSave": true,
  "editor.codeActionsOnSave": {
    "source.fixAll.eslint": "explicit"
  },
  "eslint.validate": [
    "javascript",
    "javascriptreact",
    "typescript",
    "typescriptreact",
    "vue",
    "html",
    "json",
    "jsonc",
    "markdown"
  ]
}
```

### Git Hooks

所有模板都配置了pre-commit钩子，会在提交前自动运行：
- 代码格式化
- 类型检查
- ESLint修复

## 📦 自动化模板信息生成

本项目包含一个自动化脚本，用于在代码提交时自动生成 `template.json` 文件，该文件包含了所有模板的基本信息。

### 手动生成模板信息

如果需要手动生成模板信息，可以运行：

```bash
make generate-templates
```

### 查看所有可用命令

```bash
make help
```

## 🛠️ 开发规范

### 提交信息规范

使用 [conventional commits](https://www.conventionalcommits.org/) 规范：

- `feat`: 新功能
- `fix`: 修复bug
- `docs`: 文档更新
- `style`: 代码格式调整
- `refactor`: 代码重构
- `perf`: 性能优化
- `test`: 测试相关
- `chore`: 构建过程或辅助工具的变动

### 分支规范

- `main`: 主分支，用于生产环境
- `develop`: 开发分支，用于集成测试
- `feature/*`: 功能分支
- `hotfix/*`: 紧急修复分支

## 📝 模板开发

如果你想要添加新的模板，请：

1. 在对应目录创建模板
2. 确保 package.json 中的 name 为 "pkg-name"
3. 配置 `@antfu/eslint-config`
4. 更新 `template.json`
5. 运行 `make generate-templates`

## 🤝 贡献

欢迎提交 Issue 和 Pull Request！

## 📄 许可证

MIT License

