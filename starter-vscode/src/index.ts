import type { ExtensionContext } from 'vscode'
// import { defineExtension } from 'reactive-vscode'
import { commands, window } from 'vscode'

import { HelloWorldPanel } from './HelloWorldPanel'
import { HelloWorldSidebar } from './HelloWorldSidebar'

// const { activate, deactivate } = defineExtension(() => {
// })

// export { activate, deactivate }

export function activate(context: ExtensionContext) {
  // 注册Webview视图提供者
  const provider = new HelloWorldSidebar(context.extensionUri)
  context.subscriptions.push(
    window.registerWebviewViewProvider('ExtName.basic', provider),
  )

  // 创建显示命令: ExtName.showHelloWorld
  const showHelloWorldCommand = commands.registerCommand('ExtName.showHelloWorld', () => {
    HelloWorldPanel.render(context.extensionUri)
  })

  // Add command to the extension context
  context.subscriptions.push(showHelloWorldCommand)

  window.showInformationMessage('Hello')
}
