import type { RenderProcessGoneDetails, WebContents } from 'electron'
import { join } from 'node:path'
import { app } from 'electron'
import log from 'electron-log/main'
import { createErrorWindow, createMainWindow } from './MainRunner'
import Constants from './utils/Constants'

let mainWindow
let errorWindow

function initializeMainLogger() {
  log.initialize({
    includeFutureSessions: false,
    preload: true,
  })

  const appLogFilePath = join(app.getPath('userData'), 'logs', 'applog.log')

  log.transports.file.resolvePathFn = () =>
    join(app.getPath('userData'), 'logs', 'applog.log')
  log.transports.file.level = 'silly'
  log.transports.file.format = '[{y}{m}{d} {h}:{i}:{s}.{ms}|{level}]{text}'
  log.transports.console.format = '{h}:{i}:{s}.{ms} {text}'
  log.transports.console.level = 'silly'

  log.silly(`Start logging... (Path: ${appLogFilePath}) App is ready.`)
}

app.on('ready', async () => {
  if (Constants.IS_DEV_ENV) {
    import('./index.dev')
  }

  // Disable special menus on macOS by uncommenting the following, if necessary
  /*
  if (Constants.IS_MAC) {
    systemPreferences.setUserDefault('NSDisabledDictationMenuItem', 'boolean', true)
    systemPreferences.setUserDefault('NSDisabledCharacterPaletteMenuItem', 'boolean', true)
  }
  */
  initializeMainLogger()

  mainWindow = await createMainWindow()
})

app.on('activate', async () => {
  if (!mainWindow) {
    mainWindow = await createMainWindow()
  }
})

app.on('window-all-closed', () => {
  mainWindow = null
  errorWindow = null

  if (!Constants.IS_MAC) {
    app.quit()
  }
})

app.on(
  'render-process-gone',
  (
    event: Event,
    webContents: WebContents,
    details: RenderProcessGoneDetails,
  ) => {
    errorWindow = createErrorWindow(errorWindow, mainWindow, details)
  },
)

process.on('uncaughtException', () => {
  errorWindow = createErrorWindow(errorWindow, mainWindow)
})
