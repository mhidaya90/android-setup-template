
package __PACKAGE_NAME__.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import __PACKAGE_NAME__.data.db.dao.UserDao
import __PACKAGE_NAME__.data.db.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
  abstract fun userDao(): UserDao
}
