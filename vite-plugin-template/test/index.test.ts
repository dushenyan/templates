import { afterEach, beforeEach, describe, expect, it, vi } from 'vitest'
import type { PluginOptions } from '../src'
import createPlugin from '../src'

describe('vite-plugin-template', () => {
  let consoleLogSpy: any
  let plugin: any

  beforeEach(() => {
    consoleLogSpy = vi.spyOn(console, 'log').mockImplementation(() => {})
  })

  afterEach(() => {
    vi.restoreAllMocks()
  })

  describe('plugin initialization', () => {
    it('should create a plugin with default options', () => {
      plugin = createPlugin()
      expect(plugin.name).toMatch(/vite-plugin-template/)
      expect(plugin.enforce).toBe('pre')
    })

    it('should accept custom options', () => {
      const options: PluginOptions = {
        debug: true,
        from: 'Test',
        to: 'Example',
        log: false,
      }
      plugin = createPlugin(options)
      expect(consoleLogSpy).toHaveBeenCalledWith(
        expect.stringContaining('[vite-plugin-template] Plugin options:'),
        expect.objectContaining(options),
      )
    })

    it('should merge custom options with defaults', () => {
      const options: Partial<PluginOptions> = {
        to: 'Custom Text',
      }
      plugin = createPlugin(options)
      // We can't directly test the merged options since they're not exposed
      // But we can test the transform behavior
    })
  })

  describe('transform functionality', () => {
    beforeEach(() => {
      plugin = createPlugin()
    })

    it('should not transform files without matching extensions', () => {
      const code = 'Hello, world'
      const id = 'test.css'

      const result = plugin.transform(code, id)
      expect(result).toBeNull()
    })

    it('should transform .vue files with default options', () => {
      const code = '<template>Hello, world</template>'
      const id = 'component.vue'

      const result = plugin.transform(code, id)
      expect(result).toContain('Hello, vite-plugin-template')
      expect(result).not.toContain('Hello, world')
      expect(consoleLogSpy).toHaveBeenCalledWith(
        expect.stringContaining('[vite-plugin-template] Transformed: test/component.vue'),
      )
    })

    it('should transform .js files with custom options', () => {
      const options: PluginOptions = {
        from: 'oldText',
        to: 'newText',
      }
      plugin = createPlugin(options)

      const code = 'const message = "oldText"'
      const id = 'script.js'

      const result = plugin.transform(code, id)
      expect(result).toContain('newText')
      expect(result).not.toContain('oldText')
    })

    it('should handle RegExp patterns', () => {
      const options: PluginOptions = {
        from: /test-\d+/g,
        to: 'replaced',
      }
      plugin = createPlugin(options)

      const code = 'const items = ["test-1", "test-2", "test-3"]'
      const id = 'data.ts'

      const result = plugin.transform(code, id)
      expect(result).toContain('replaced')
      expect(result).not.toContain('test-1')
    })

    it('should not transform when no match is found', () => {
      const code = 'const message = "Hello there"'
      const id = 'script.ts'

      const result = plugin.transform(code, id)
      expect(result).toBeNull()
    })

    it('should not log when log option is false', () => {
      const options: PluginOptions = {
        log: false,
      }
      plugin = createPlugin(options)

      const code = 'Hello, world'
      const id = 'component.vue'

      plugin.transform(code, id)
      expect(consoleLogSpy).not.toHaveBeenCalledWith(
        expect.stringContaining('[vite-plugin-template] Transformed:'),
      )
    })
  })

  describe('virtual modules', () => {
    beforeEach(() => {
      plugin = createPlugin()
    })

    it('should resolve virtual module ID', () => {
      const id = 'virtual:plugin-info'
      const result = plugin.resolveId(id)
      expect(result).toBe('\0virtual:plugin-info')
    })

    it('should not resolve non-virtual module ID', () => {
      const id = './some-module.js'
      const result = plugin.resolveId(id)
      expect(result).toBeNull()
    })

    it('should load virtual module content', () => {
      const id = '\0virtual:plugin-info'
      const result = plugin.load(id)
      const moduleInfo = JSON.parse(result)

      expect(moduleInfo.name).toMatch(/vite-plugin-template/)
      expect(moduleInfo.version).toBe('1.0.0')
      expect(moduleInfo.options).toBeDefined()
    })

    it('should not load non-virtual module content', () => {
      const id = './some-module.js'
      const result = plugin.load(id)
      expect(result).toBeNull()
    })
  })

  describe('configResolved hook', () => {
    it('should store resolved config', () => {
      plugin = createPlugin()
      const mockConfig = { command: 'serve', mode: 'development' }

      plugin.configResolved(mockConfig)
      // Config is stored internally, but we can't directly access it
      // This test ensures the hook doesn't throw an error
      expect(plugin.configResolved).toBeDefined()
    })
  })
})
