<script lang="ts">
import { defineBasicLoader } from 'unplugin-vue-router/data-loaders/basic'
import { usePing } from '@/composables/usePing'

const { fetchPing } = usePing()

export const usePingData = defineBasicLoader('/about', async (to) => {
  return fetchPing().then(res => {
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

const { data: ping, isLoading, error, reload } = usePingData()
</script>


<template>
  <PageScaffold title="About">
    <div v-if="!isLoading" class="flex flex-col gap-2 mt-4 items-stretch">
      Name: {{ ping.name }} <br/>
      Version: {{ ping.version }}<br/>
      Build time: {{ ping.buildTime }}<br/>
      Active Profiles: {{ ping.activeProfiles }}<br/>
      Server Time: {{ ping.serverTime }}<br/>
    </div>
  </PageScaffold>
</template>

<style>

</style>
