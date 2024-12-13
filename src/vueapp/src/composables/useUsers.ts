import useApiClient from '@/composables/useApiClient'
import type { paths } from '@/generated/api'
import type { ParamsOption, RequestBodyOption } from 'openapi-fetch'

type UserRequest = RequestBodyOption<paths['/users/{id}']['put']>['body']

export const useUsers = () => {
  const client = useApiClient()

  const fetchUsers = async () => {
    return client.GET('/users')
  }

  const fetchUser = async (id: string) => {
    return client.GET('/users/{id}', {
      params: {
        path: { id }
      }
    })
  }

  const putUser = async (id: string, user: UserRequest) => {
    return client.PUT('/users/{id}', {
      body: user,
      params: {
        path: {
          id
        }
      }
    })
  }

  return { fetchUser, fetchUsers, putUser }
}
