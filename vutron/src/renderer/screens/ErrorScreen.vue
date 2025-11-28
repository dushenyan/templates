<template>
  <div class="error-screen-container">
    <a-result
      status="error"
      title="Unknown error occurred"
      subtitle="An unexpected error has occurred. Please try again later."
    >
      <template #extra>
        <a-button type="primary" @click="$router.push('/')">
          Go Home
        </a-button>
      </template>
    </a-result>
  </div>
</template>

<style scoped>
.error-screen-container {
  max-width: 600px;
  margin: 100px auto;
  padding: 20px;
}
</style>
