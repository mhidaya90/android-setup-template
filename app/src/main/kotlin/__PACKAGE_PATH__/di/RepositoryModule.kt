
package __PACKAGE_NAME__.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import __PACKAGE_NAME__.data.repository.UserRepository
import __PACKAGE_NAME__.data.repository.UserRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
  @Binds @Singleton
  abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
}