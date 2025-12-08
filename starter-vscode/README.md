# pkg-name

## 介绍

这是一个 VS Code 扩展的模板项目，使用 Vue 3 + TypeScript + reactive-vscode 构建。

### 特性

- ✅ 使用 TypeScript 和 Vue 3 构建
- ✅ 基于 reactive-vscode 框架
- ✅ 集成 ESLint 代码格式化
- ✅ 支持 Webview 侧边栏和面板
- ✅ 热重载开发体验
- ✅ 自动化构建和发布

### 快速开始

1. 克隆此模板：
   ```bash
   git clone https://github.com/your-username/pkg-name.git my-extension
   cd my-extension
   ```

2. 安装依赖：
   ```bash
   pnpm install
   ```

3. 修改 `package.json` 中的扩展信息：
   - `name`: 扩展名称
   - `displayName`: 显示名称
   - `publisher`: 发布者用户名
   - `description`: 扩展描述

4. 开始开发：
   ```bash
   pnpm dev
   ```

5. 在 VS Code 中按 `F5` 运行扩展

### 项目结构

```
.
├── src/                    # 扩展源码
│   ├── HelloWorldPanel.ts  # 面板组件
│   ├── HelloWorldSidebar.ts # 侧边栏组件
│   ├── index.ts            # 扩展入口
│   └── utils/              # 工具函数
├── webview-ui/             # Webview 界面 (Vue 3)
│   └── src/
│       ├── App.vue         # 主组件
│       └── main.ts         # 入口文件
└── res/                    # 资源文件
```

## 配置

<!-- configs -->

**No data**

<!-- configs -->

## 命令

<!-- commands -->

| Command                  | Title                   |
| ------------------------ | ----------------------- |
| `PkgName.showHelloWorld` | Hello World (Vue): Show |

<!-- commands -->

## 开发脚本

- `pnpm dev` - 启动开发模式
- `pnpm build` - 构建扩展
- `pnpm lint` - 代码检查
- `pnpm test` - 运行测试
- `pnpm ext:package` - 打包扩展
- `pnpm ext:publish` - 发布扩展
