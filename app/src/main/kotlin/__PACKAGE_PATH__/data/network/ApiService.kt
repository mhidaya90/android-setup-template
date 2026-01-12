package __PACKAGE_NAME__.data.network

import retrofit2.http.GET

data class ApiUser(val id: Long, val name: String, val email: String)

interface ApiService {
  @GET("users")
  suspend fun getUsers(): List<ApiUser>
}
