
package __PACKAGE_NAME__.data.repository

import __PACKAGE_NAME__.data.db.dao.UserDao
import __PACKAGE_NAME__.data.db.entities.UserEntity
import __PACKAGE_NAME__.data.network.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
  private val api: ApiService,
  private val dao: UserDao
) : UserRepository {

  override fun users(): Flow<List<UserEntity>> = dao.observeAll()

  override suspend fun refresh() {
    val remote = api.getUsers()
    dao.upsertAll(remote.map { UserEntity(it.id, it.name, it.email) })
  }
}