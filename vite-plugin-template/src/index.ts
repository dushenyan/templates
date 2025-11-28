import type { Plugin } from 'vite'
import { createPluginName } from './shared/create'

interface Options { }

const useName = createPluginName()

const usePlugin = (options?: Partial<Options>): Plugin => {
	return {
		name: useName('name'),
		transform(code, id) {
			// 在这里编写你的插件逻辑
			console.clear()
			const cleanId = id.split('?')[0]
			if (!cleanId.endsWith('.vue'))
				return
			let codes = code
			codes = codes.replace(/Hello, world/g, 'Hello, shenyan')
			return codes
		}
	}
}

export default usePlugin
