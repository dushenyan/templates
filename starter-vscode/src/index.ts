import type { ExtensionContext } from 'vscode'
import { commands, window } from 'vscode'

import { HelloWorldPanel } from './HelloWorldPanel'
import { HelloWorldSidebar } from './HelloWorldSidebar'

export function activate(context: ExtensionContext) {
  // 注册Webview视图提供者
  const provider = new HelloWorldSidebar(context.extensionUri)
  context.subscriptions.push(
    window.registerWebviewViewProvider('PkgName.basic', provider),
  )

  // 创建显示命令: PkgName.showHelloWorld
  const showHelloWorldCommand = commands.registerCommand('PkgName.showHelloWorld', () => {
    HelloWorldPanel.render(context.extensionUri)
  })

  // Add command to the extension context
  context.subscriptions.push(showHelloWorldCommand)

  window.showInformationMessage('Hello')
}
