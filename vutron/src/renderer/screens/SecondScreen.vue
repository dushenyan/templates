<script setup lang="tsx">
import { IconThunderbolt } from '@arco-design/web-vue/es/icon'
import { useI18n } from 'vue-i18n'

const { t } = useI18n()
</script>

<template>
  <div class="second-screen-container">
    <a-row justify="center">
      <a-col :span="24" class="text-center">
        <div class="emoji-icon">
          <IconThunderbolt />
        </div>
      </a-col>
      <a-col :span="24" class="description my-4">
        {{ t('desc.second-desc') }}
      </a-col>

      <a-col :span="24" class="my-4">
        <a-date-picker style="width: 300px;" />
      </a-col>
    </a-row>
  </div>
</template>

<style scoped>
.second-screen-container {
  max-width: 600px;
  margin: 0 auto;
  padding: 40px 20px;
  text-align: center;
}

.text-center {
  text-align: center;
}

.emoji-icon {
  font-size: 250px;
  color: #009f57;
  margin-bottom: 24px;
  transition: filter 0.3s cubic-bezier(0.4, 0, 0.2, 1);
}

.arco-theme-dark .emoji-icon {
  filter: brightness(1.2) saturate(1.1);
}

.description {
  font-size: 1.1rem;
  color: #333;
  line-height: 1.6;
  transition: color 0.3s cubic-bezier(0.4, 0, 0.2, 1);
}

.arco-theme-dark .description {
  color: #e0e0e0 !important;
}

.my-4 {
  margin: 24px 0;
}
</style>
