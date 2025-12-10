# vite-plugin-template

一个功能丰富的 Vite 插件开发模板，提供开箱即用的开发环境和最佳实践

## ✨ 特性

- 🚀 **TypeScript 支持** - 完整的 TypeScript 开发环境和类型检查
- 🧪 **测试驱动** - 集成 Vitest 测试框架，支持单元测试和覆盖率报告
- 📦 **开箱即用** - 预配置的 ESLint、TypeScript 和构建工具链
- 🔧 **开发友好** - 热重载、源码映射和开发服务器
- 📚 **文档完善** - 详细的 API 文档和使用示例
- 🎯 **最佳实践** - 遵循 Vite 插件开发规范和社区最佳实践

## 🛠️ 安装

```shell
# 克隆项目
git clone https://github.com/your-username/vite-plugin-template.git
cd vite-plugin-template

# 安装依赖
pnpm install

# 开发模式
pnpm dev
```

## 🚀 使用方法

### 基本用法

```typescript
// vite.config.ts
import { defineConfig } from 'vite'
import YourPlugin from 'vite-plugin-template'

export default defineConfig({
  plugins: [
    YourPlugin({
      // 插件选项
    })
  ]
})
```

### 插件配置

```typescript
// 插件选项接口
interface Options {
  // 在这里定义插件的配置选项
}

// 使用自定义配置
export default defineConfig({
  plugins: [
    YourPlugin({
      // 你的自定义配置
    })
  ]
})
```

## 📦 开发命令

```shell
# 开发模式 (监听文件变化)
pnpm dev

# 构建插件
pnpm build

# 运行测试
pnpm test

# 监听模式运行测试
pnpm test:watch

# 生成覆盖率报告
pnpm coverage

# 代码检查
pnpm lint

# 自动修复代码风格问题
pnpm lint:fix

# 类型检查
pnpm type-check

# 示例项目开发
pnpm play

# 发布版本
pnpm release
```

## 🧪 测试

这个项目使用 Vitest 进行测试。测试文件位于 `test/` 目录中。

```shell
# 运行所有测试
pnpm test

# 监听模式运行测试
pnpm test:watch

# 生成覆盖率报告
pnpm coverage
```

## 📁 项目结构

```
vite-plugin-template/
├── src/                  # 插件源码
│   ├── index.ts         # 插件入口文件
│   └── shared/          # 共享工具函数
├── test/                # 测试文件
├── playground/            # 示例项目
├── dist/               # 构建输出
├── package.json        # 项目配置
├── tsconfig.json      # TypeScript 配置
├── tsdown.config.ts   # 构建工具配置
└── README.md          # 项目文档
```

## 🤝 贡献

欢迎提交 Issue 和 Pull Request！

1. Fork 这个仓库
2. 创建你的特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交你的修改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 打开一个 Pull Request
