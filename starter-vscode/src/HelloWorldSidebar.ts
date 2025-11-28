import type { Disposable, Webview, WebviewView, WebviewViewProvider } from 'vscode'
import { Uri, window } from 'vscode'
import { getNonce } from './utils/getNonce'
import { getUri } from './utils/getUri'

export class HelloWorldSidebar implements WebviewViewProvider {
  private _view?: WebviewView
  private _disposables: Disposable[] = []

  constructor(private readonly _extensionUri: Uri) {}

  public resolveWebviewView(webviewView: WebviewView) {
    this._view = webviewView

    // 配置Webview选项
    webviewView.webview.options = {
      enableScripts: true,
      localResourceRoots: [Uri.joinPath(this._extensionUri, 'out'), Uri.joinPath(this._extensionUri, 'webview-ui/build')],
    }

    // 设置Webview内容
    webviewView.webview.html = this._getWebviewContent(webviewView.webview)

    // 设置消息监听
    this._setWebviewMessageListener(webviewView.webview)

    // 监听视图可见性变化
    webviewView.onDidChangeVisibility(() => {
      if (webviewView.visible) {
        // 视图变为可见时的处理
      }
    })

    // 监听视图销毁事件
    webviewView.onDidDispose(() => this.dispose(), null, this._disposables)
  }

  public dispose() {
    while (this._disposables.length) {
      const disposable = this._disposables.pop()
      if (disposable) {
        disposable.dispose()
      }
    }
  }

  private _getWebviewContent(webview: Webview) {
    const stylesUri = getUri(webview, this._extensionUri, ['webview-ui', 'build', 'assets', 'index.css'])
    const scriptUri = getUri(webview, this._extensionUri, ['webview-ui', 'build', 'assets', 'index.js'])
    const nonce = getNonce()

    return /* html */ `
      <!DOCTYPE html>
      <html lang="en">
        <head>
          <meta charset="UTF-8" />
          <meta name="viewport" content="width=device-width, initial-scale=1.0" />
          <meta http-equiv="Content-Security-Policy" content="default-src 'none'; style-src ${webview.cspSource}; script-src 'nonce-${nonce}';">
          <link rel="stylesheet" type="text/css" href="${stylesUri}">
          <title>Basic Configurator</title>
        </head>
        <body>
          <div id="app"></div>
          <script type="module" nonce="${nonce}" src="${scriptUri}"></script>
        </body>
      </html>
    `
  }

  private _setWebviewMessageListener(webview: Webview) {
    webview.onDidReceiveMessage(
      (message: any) => {
        const command = message.command
        const text = message.text

        switch (command) {
          case 'hello':
            window.showInformationMessage(text)
            break
        }
      },
      undefined,
      this._disposables,
    )
  }
}
