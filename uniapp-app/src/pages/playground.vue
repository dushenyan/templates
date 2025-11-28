<script setup lang="ts">
definePage({
  style: {
    navigationBarTitleText: '演练场',
  },
  name: 'playground',
  layout: 'tabbar',
})

const router = useRouter()

// 示例模块列表
const exampleModules = ref([
  { name: '表单示例', path: '/pages-sub/example/hi' },
  { name: '列表示例', path: '/pages-sub/example/request' },
  { name: '图表示例', path: '/pages-sub/example/comp' },
  { name: '地图示例', path: '/pages-sub/example/index' },
  { name: 'Paing示例', path: '/pages-sub/example/paing' },
])

function navigateToExample(path: string) {
  router.push(path)
}
</script>

<template>
  <div class="center flex-col mx-4">
    <!-- 示例模块卡片区域 -->
    <div class="w-full  mt-6">
      <h3 class="text-lg font-semibold mb-4">
        示例模块
      </h3>
      <div class="grid grid-cols-2 gap-4">
        <div
          v-for="(item, index) in exampleModules" :key="index"
          class="bg-white rounded-lg shadow p-4 flex items-center justify-between cursor-pointer hover:bg-gray-50 transition-colors"
          @click="navigateToExample(item.path)"
        >
          <span>{{ item.name }}</span>
          <wd-icon name="arrow-right" />
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.btn {
  @apply py-2 px-4 bg-blue-500 text-white rounded hover:bg-blue-600 disabled:bg-gray-400 disabled:cursor-not-allowed;
}
</style>
