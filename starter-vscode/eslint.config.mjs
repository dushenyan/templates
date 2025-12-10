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
      'no-console': 'off',
    },
  },
)
