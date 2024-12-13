<script setup lang="ts">
const props = defineProps<{
  title?: string
}>()

</script>

<template>
  <main class="mx-12 my-4 flex flex-col items-stretch">
    <div>
      <h1 class="text-xl font-medium">
        <template v-if="title">
          {{ title }}
        </template>
        <slot v-else name="title" />
      </h1>
      <div class="flex items-center justify-end">
        <slot name="actions" />
      </div>
    </div>
    <slot />
  </main>
</template>

<style scoped>

</style>
