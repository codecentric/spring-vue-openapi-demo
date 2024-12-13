<script setup lang="ts">

import IonHomeOutline from '@/components/icons/IonHomeOutline.vue'
import IonPeopleOutline from '@/components/icons/IonPeopleOutline.vue'
</script>

<template>
  <nav class="bg-gray-100 rounded-e-xl p-4 flex flex-col gap-2">
    <RouterLink to="/" class="text-center text-xl font-bold mb-2">
      Spring Boot<br>+<br>Vue.js
    </RouterLink>
    <RouterLink to="/" class="nav-link">
      <IonHomeOutline />
      Home
    </RouterLink>
    <RouterLink to="/about" class="nav-link">
      About
    </RouterLink>
    <RouterLink to="/users" class="nav-link">
      <IonPeopleOutline />
      Users
    </RouterLink>
  </nav>
</template>

<style scoped>
.nav-link {
  @apply px-3 py-2 flex gap-2 bg-gray-200 rounded-xl hover:bg-gray-300 font-semibold text-gray-800;

  > svg {
    @apply w-6 h-6;
  }
}
</style>
