import { describe, expect, it } from 'vitest'
import packages  from '../package.json'
import newPlugin from '../src/index'

describe('init', () => {
	it('init test', () => {
		expect(1).toBe(1)
	})

	it('should transform code correctly', () => {
		const usePlugin = newPlugin()
		// Mock Vite's plugin context or create a test environment to run your plugin
		// Assert the expected output or side effects of your plugin
		expect(usePlugin.name).toBe(packages.name);
		// Add more specific tests for your plugin's functionality

		expect(usePlugin.enforce).toBe('pre');
	});
})

