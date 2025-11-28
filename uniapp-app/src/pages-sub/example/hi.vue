<script setup lang="ts">
definePage({
  style: {
    navigationBarTitleText: 'hi',
  },
})

const name = ref('')
const router = useRouter()

function goToSub() {
  router.push(`/pages-sub/index?name=${name.value}`)
}
</script>

<template>
  <div class="center flex-col">
    <TheLogo />

    <wd-icon name="add-circle" />

    <div py-4 />

    <TheInput
      v-model:value="name"
      placeholder="What's your name?"
    />

    <div>
      <button
        m-3 text-sm btn
        :disabled="!name"
        @click="goToSub()"
      >
        Go
      </button>
    </div>

    <TheFooter />
  </div>
</template>
