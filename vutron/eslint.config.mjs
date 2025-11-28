import antfu from '@antfu/eslint-config'

export default antfu({
  type: 'app',

  vue3: true,

  typescript: true,
}, {
  rules: {
    'node/prefer-global/process': 'off',
  },
})
