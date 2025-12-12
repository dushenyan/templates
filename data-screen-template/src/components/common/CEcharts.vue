<script lang="ts" setup>
import * as echarts from 'echarts'
import { onBeforeUnmount, onMounted, reactive, ref, watch } from 'vue'

const prop = withDefaults(defineProps<{ option: object }>(), {
  option: () => {
    return {}
  },
})

const emit = defineEmits(['eclick', 'onload'])

let echartsInstance: echarts.ECharts | null = null

const state = reactive({
  option: null,
})
watch(
  () => prop.option,
  () => {
    state.option = prop.option
    if (state.option) {
      echartsInstance?.setOption(state.option)
      emit('onload', echartsInstance)
    }
  },
  { immediate: false, deep: true },
)
const echartsRef = ref()
defineExpose({
  setDataZoom,
})
function echartsResize() {
  console.log('resize')
  echartsInstance?.resize()
}
function setDataZoom(start: any, end: any) {
  ;(state.option as any).dataZoom[0].start = start
  ;(state.option as any).dataZoom[0].end = end
  echartsInstance?.setOption(state.option as any)
}
onMounted(() => {
  state.option = prop.option
  if (echartsInstance) {
    if (state.option) {
      echartsInstance?.setOption(state.option)
    }
  }
  else {
    echartsInstance = echarts.init(echartsRef.value as HTMLDivElement)
    echartsInstance.on('click', (val) => {
      Eaclick(val)
    })
    if (state.option) {
      echartsInstance?.setOption(state.option)
    }
  }
  window.addEventListener('resize', echartsResize)
})
function Eaclick(val: any) {
  emit('eclick', val)
}
onBeforeUnmount(() => {
  if (!echartsInstance)
    return
  window.removeEventListener('resize', echartsResize)
  echartsInstance.dispose()
})
</script>

<template>
  <div ref="echartsRef" class="echarts" />
</template>

<style scoped lang="scss">
.echarts {
  position: relative;
  width: 100%;
  height: 100%;
  margin: auto;
}
</style>
