<template>
  <div class="home card">
    <img class="home-bg" src="@/assets/images/welcome.png" alt="welcome" />
  </div>
</template>

<script setup lang="ts" name="home">
import { typeApis } from '@/api/modules/login';
import { onMounted } from 'vue';

onMounted(() => {
  typeApis().then((res) => {
    console.log('res', res);
  })
})
</script>

<style scoped lang="scss">
@use "./index.scss" as *;
</style>
