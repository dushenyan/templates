<script setup lang="ts">
import { provideVSCodeDesignSystem, vsCodeButton, vsCodeDropdown, vsCodeOption } from '@vscode/webview-ui-toolkit'
import { vscode } from './utils/vscode'

// In order to use the Webview UI Toolkit web components they
// must be registered with the browser (i.e. webview) using the
// syntax below.
provideVSCodeDesignSystem().register(vsCodeButton(), vsCodeDropdown(), vsCodeOption())

// To register more toolkit components, simply import the component
// registration function and call it from within the register
// function, like so:
//
// provideVSCodeDesignSystem().register(
//   vsCodeButton(),
//   vsCodeCheckbox()
// );
//
// Finally, if you would like to register all of the toolkit
// components at once, there's a handy convenience function:
//
// provideVSCodeDesignSystem().register(allComponents);

function handleHowdyClick() {
  vscode.postMessage({
    command: 'hello',
    text: 'Hey there partner! 🤠',
  })
}
</script>

<template>
  <main>
    <h1>Hello world!</h1>
    <vscode-button @click="handleHowdyClick">
      Howdy!
    </vscode-button>
    <vscode-dropdown position="below" style="margin-top: 10px;">
      <vscode-option>Option Label #1</vscode-option>
      <vscode-option>Option Label #2</vscode-option>
      <vscode-option>Option Label #3</vscode-option>
    </vscode-dropdown>
  </main>
</template>

<style>
main {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-start;
  height: 100%;
}
</style>
