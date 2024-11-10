package art5hur.com.github.listadecompras.data

import androidx.room.Database
import androidx.room.RoomDatabase
import art5hur.com.github.listadecompras.model.ItemModel

@Database(entities = [ItemModel::class], version = 1)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao
}