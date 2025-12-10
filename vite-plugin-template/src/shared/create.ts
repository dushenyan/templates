export function createPluginName(reusable: boolean = false) {
  let i = 0
  return (name: string) => {
    const base = `vite-plugin-${name}`
    return reusable ? `${base}:${i++}` : base
  }
}

export function createVirtualModuleID(name: string): {
  virtualModuleId?: string
  resolvedVirtualModuleId?: string
} {
  const virtualModuleId = `virtual:${name}`
  const resolvedVirtualModuleId = `\0${virtualModuleId}`
  return {
    virtualModuleId,
    resolvedVirtualModuleId,
  }
}
