<script lang="ts">
import { defineBasicLoader } from 'unplugin-vue-router/data-loaders/basic'
import { useUsers } from '@/composables/useUsers'
import { NavigationResult } from 'unplugin-vue-router/data-loaders'

const { fetchUser, putUser } = useUsers()

export const useUserData = defineBasicLoader('/users/[id]', async (to) => {
  return fetchUser(to.params.id).then(res => {
    console.log(res)
    if (res.error) {
      console.log(res)
      if (res.response.status === 404) {
        return new NavigationResult("/users")
      }
      throw new Error(res.error.message)
    } else {
      return res.data!
    }
  })
})
</script>


<script setup lang="ts">
import PageScaffold from '@/components/PageScaffold.vue'

const { data, isLoading, error, reload } = useUserData()

const submit = () => {
  putUser(data.value.id, data.value).then((res) => {
    reload()
  })
}
</script>

<template>
  <PageScaffold title="User">
    <template #actions>
      <button class="px-3 py-2 bg-green-400 text-white rounded-lg" @click="submit">Save</button>
    </template>
    <form @submit.prevent v-if="!isLoading && data">
      <div>
        <label for="firstName">First Name</label>
        <input name="firstName" v-model="data.firstName">
      </div>
      <div>
        <label for="lastName">Last Name</label>
        <input name="lastName" v-model="data.lastName">
      </div>
    </form>
  </PageScaffold>
</template>

<style scoped>
form {
  @apply flex flex-col gap-4 mt-2;

  div {
    @apply flex flex-col;

    label {
      @apply uppercase text-xs font-medium mb-1;
    }

    input {
      @apply bg-gray-100 px-2 py-1 rounded focus-visible:outline-none focus-visible:ring-green-500 focus-visible:ring-1;
    }
  }
}
</style>
