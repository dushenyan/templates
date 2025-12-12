import antfu from '@antfu/eslint-config'

export default antfu({
  type: 'lib',

  vue: true,

  typescript: true,

  ignores: [
    'public',
    'design',
  ],
}, {
  rules: {
    'no-console': 'off',
    'array-callback-return': 'off',
    'ts/explicit-function-return-type': 'off',
  },
})
