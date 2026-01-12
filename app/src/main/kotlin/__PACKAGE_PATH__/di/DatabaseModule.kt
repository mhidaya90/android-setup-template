
package __PACKAGE_NAME__.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import __PACKAGE_NAME__.data.db.AppDatabase
import __PACKAGE_NAME__.data.db.dao.UserDao

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

  @Provides @Singleton
  fun provideDatabase(@ApplicationContext ctx: Context): AppDatabase =
    Room.databaseBuilder(ctx, AppDatabase::class.java, "app.db").build()

  @Provides
  fun provideUserDao(db: AppDatabase): UserDao = db.userDao()
}