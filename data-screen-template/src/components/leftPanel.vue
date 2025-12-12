<!-- 左侧数据面板 -->
<script setup lang="ts">
import ageDistribution from './leftPanel/ageDistribution.vue'
import rankingOfScenicSpots from './leftPanel/rankingOfScenicSpots.vue'
import receptionOfTourists from './leftPanel/receptionOfTourists.vue'
</script>

<template>
  <div class="left-panel">
    <!-- 景点人流排名 -->
    <rankingOfScenicSpots />
    <!-- 游客年龄分布 -->
    <ageDistribution />
    <!-- 年度接待游客比 -->
    <receptionOfTourists />
  </div>
</template>

<style lang="scss" scoped>
.left-panel {
  position: absolute;
  width: 500px;
  height: 100%;
  left: 0;
  top: 0;
  display: grid;
  gap: 24px;
  padding: 111px 0 34px 16px;
  box-sizing: border-box;
  grid-template-columns: 1fr;
  grid-template-rows: repeat(3, 1fr);
}
.panel{
  left:-500px;
  animation: entranceAnimation ease-in-out 0.75s  forwards;
}
@keyframes entranceAnimation {
  0%{
    left: -500px;
  }
  100%{
    left: 0;
  }
}
</style>
