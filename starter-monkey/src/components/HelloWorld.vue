<script setup lang="ts">
import { ref } from 'vue';

defineProps<{ msg: string }>()

const count = ref(0)
</script>

<template>
  <h2>{{ msg }}，开始你的工作吧！</h2>

  <button type="button" @click="count++">
    count is {{ count }}
  </button>
</template>

<style scoped>
h2 {
  font-size: 18px;
  margin-bottom: .75rem;
  line-height: 1.5em;
  color: #888;
}
</style>
