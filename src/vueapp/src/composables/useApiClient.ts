import createClient from 'openapi-fetch'
import type { paths } from '@/generated/api'

export default () => {
  // declare fetcher for paths
  return createClient<paths>({
    baseUrl: '/api',
  })
}
