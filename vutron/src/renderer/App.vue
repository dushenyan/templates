<script setup lang="tsx">
import { DefaultLayout } from '@/renderer/components/layout'
</script>

<template>
  <DefaultLayout>
    <router-view />
  </DefaultLayout>
</template>

<style>
@import './styles/mac-style.css';

html {
  overflow-y: auto !important;
  user-select: none;
}

html,
body {
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
  background-color: #ffffff;
  color: #000000;
  transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
}

/* Dark theme support via Arco Design theme system */
.arco-theme-dark html,
.arco-theme-dark body {
  background-color: #000000;
  color: #ffffff;
}

/* Enhanced Mac styles */
.arco-app {
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif !important;
}

/* Smooth color transitions */
* {
  transition: background-color 0.3s ease, color 0.3s ease, border-color 0.3s ease;
}

/* Arco Design macOS theme overrides */
.arco-btn {
  font-weight: 500 !important;
  letter-spacing: 0.01em !important;
  transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1) !important;
}

.arco-card {
  backdrop-filter: blur(20px);
  -webkit-backdrop-filter: blur(20px);
  transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
}

/* Theme-specific card styles */
.arco-theme-dark .arco-card {
  background-color: rgba(30, 30, 30, 0.9);
  border-color: rgba(255, 255, 255, 0.1);
}

/* Button hover effects in dark theme */
.arco-theme-dark .arco-btn.arco-btn-primary:hover {
  background: linear-gradient(135deg, #409CFF 0%, #7B6AFF 100%);
  box-shadow: 0 8px 16px rgba(10, 132, 255, 0.4) !important;
}
</style>
