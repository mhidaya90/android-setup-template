
package __PACKAGE_NAME__.data.repository

import kotlinx.coroutines.flow.Flow
import __PACKAGE_NAME__.data.db.entities.UserEntity

interface UserRepository {
  fun users(): Flow<List<UserEntity>>
  suspend fun refresh()
}