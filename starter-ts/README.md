# pkg-name

## 介绍

一个快速创建现代库的 TypeScript 库模板，使用 TypeScript、ESLint、Prettier、Vitest 等工具。

## 特性

- 🚀 使用 TypeScript 构建
- 📦 使用 tsdown 零配置构建
- ✨ 集成 ESLint 和 Prettier
- 🧪 使用 Vitest 进行测试
- 📋 使用 lint-staged 进行 Git 钩子
- 🚀 CI/CD 使用 GitHub Actions
- 📚 自动生成 API 文档

## 快速开始

```bash
# 克隆这个模板
git clone https://github.com/your-username/pkg-name.git my-new-package
cd my-new-package

# 安装依赖
pnpm install

# 开始开发
pnpm dev

# 运行测试
pnpm test

# 构建生产环境
pnpm build
```

## 使用

```ts
import { one, two } from 'pkg-name'

console.log(one) // 1
console.log(two) // 2
```

## 开发

这个模板使用 [npm Trusted Publisher](https://github.com/e18e/ecosystem-issues/issues/201) 进行安全发布，通过 CI 进行发布。

### 设置

1. 手动运行 `pnpm publish` 第一次发布到 npm
2. 前往 `https://www.npmjs.com/package/pkg-name/access` 连接你的 GitHub 仓库
3. 以后的发布可以使用 `pnpm run release`

### 脚本

- `pnpm dev` - 启动开发模式并监听
- `pnpm build` - 构建库
- `pnpm test` - 运行测试
- `pnpm lint` - 运行 ESLint
- `pnpm typecheck` - 运行 TypeScript 类型检查
- `pnpm release` - 发布新版本
