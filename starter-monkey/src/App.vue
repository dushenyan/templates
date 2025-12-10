<script setup lang="ts">
import HelloWorld from './components/HelloWorld.vue';
</script>

<template>
  <div class="monkey-app">
    <HelloWorld msg="欢迎使用油猴插件模板" />
  </div>
</template>

<style scoped>
.monkey-app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  color: #2c3e50;
  margin: 20px;
  position: fixed;
  right: 0;
  top: 15vh;
  background-color: white;
  z-index: 99999;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
