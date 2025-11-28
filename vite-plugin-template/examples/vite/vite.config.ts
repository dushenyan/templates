import { defineConfig } from 'vite'
import Vue from '@vitejs/plugin-vue'
import Inspect from 'vite-plugin-inspect'
import Names from '../../src/index'

export default defineConfig({
	plugins: [
		Vue(), 
		Inspect(),
		Names()
	],
})
