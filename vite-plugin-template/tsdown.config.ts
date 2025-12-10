import { defineConfig } from 'tsdown'

export default defineConfig({
  dts: true,
  clean: true,
  minify: false,
  outDir: 'dist',
  format: ['cjs', 'esm'],
  entry: ['src/index.ts'],
  noExternal: ['slash'],
  watch: true,
})
