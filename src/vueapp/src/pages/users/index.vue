<script lang="ts">
import { defineBasicLoader } from 'unplugin-vue-router/data-loaders/basic'
import { useUsers } from '@/composables/useUsers'

const { fetchUsers } = useUsers()

export const useUsersData = defineBasicLoader('/users/', async (to) => {
  return fetchUsers().then(res => {
    if (res.error) {
      throw new Error(res)
    } else {
      return res.data!
    }
  })
})
</script>

<script setup lang="ts">
import PageScaffold from '@/components/PageScaffold.vue'

const { data: users, isLoading, error, reload } = useUsersData()
</script>

<template>
  <PageScaffold title="Users">
    <div v-if="!isLoading" class="flex flex-col gap-2 mt-4 items-stretch">
      <RouterLink v-for="user in users" :to="'/users/'+user.id"
                  class="bg-gray-100 hover:bg-gray-200 rounded-xl px-3 py-2 w-full">
        {{ user.firstName }} {{ user.lastName }}
      </RouterLink>
    </div>
  </PageScaffold>
</template>

<style scoped>

</style>
