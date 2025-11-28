<script lang="ts" setup>
definePage({
  style: {
    navigationBarTitleText: '用户',
  },
})

const data = reactive({
  value: 1,
  range: [
    { value: 0, text: '篮球' },
    { value: 1, text: '足球' },
    { value: 2, text: '游泳' },
  ],
})

// 使用模板字符串定义多行 Markdown 内容
const content = ref('')

function change(e: string | number | undefined) {
  console.log('e:', e)
}
</script>

<template>
  <view class="px-3 py-20 text-center">
    <view class="text-2xl text-gray-9!">
      <wd-text custom-class="text-gray-9!" text="欢迎使用 Wot Design Uni！1" />
    </view>
    <!--  <uni-card>
      <text>这是一个基础卡片示例，内容较少，此示例展示了一个没有任何属性不带阴影的卡片。</text>
    </uni-card>
    <wd-button>主要按钮</wd-button>
    <uni-section title="修改字体大小" sub-title="设置 font-size 属性设置组件大小" type="line" padding>
      <uni-countdown :font-size="30" :day="1" :hour="2" :minute="30" :second="0" />
    </uni-section>
    <view>
      <uni-data-select v-model="data.value" :localdata="data.range" @change="change" />
    </view> -->

    <view class="text-left">
      <wd-textarea v-model="content" placeholder="请填写评价" />
      <!-- <zero-markdown-view :markdown="content" /> -->
    </view>
  </view>
</template>
