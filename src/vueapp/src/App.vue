<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import Sidebar from '@/components/Sidebar.vue'
</script>

<template>
  <div class="flex h-full">
    <Sidebar class="h-full" />
    <RouterView class="flex-grow" />
  </div>
</template>

<style scoped>

</style>
