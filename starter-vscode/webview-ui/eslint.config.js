// @ts-check
import antfu from '@antfu/eslint-config'

export default antfu(
  {
    ignores: [
      'dist',
      'node_modules',
      'coverage',
    ],
  },
  {
    rules: {
      // 可以在这里添加特定的规则覆盖
    },
  },
)