import useApiClient from '@/composables/useApiClient'
import type { paths } from '@/generated/api'
import type { ParamsOption, RequestBodyOption } from 'openapi-fetch'

export const usePing = () => {
  const client = useApiClient()

  const fetchPing = async () => {
    return client.GET('/ping')
  }

  return { fetchPing }
}
