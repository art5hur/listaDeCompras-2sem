package art5hur.com.github.listadecompras.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import art5hur.com.github.listadecompras.data.ItemDao
import art5hur.com.github.listadecompras.data.ItemDatabase
import art5hur.com.github.listadecompras.model.ItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * O objetivo dessa ViewModel será abstrair comportamentos
 * que, até então, estavam sendo feitos na Activity e no Adapter
 * em nosso projeto.
 *
 *
 */
class ItemsViewModel(application: Application) : AndroidViewModel(application) {

    private val itemDao: ItemDao
    val itemsLiveData: LiveData<List<ItemModel>>

    init {
        val database = Room.databaseBuilder(
            getApplication(),
            ItemDatabase::class.java,
            "items_database"
        ).build()

        itemDao = database.itemDao()
        itemsLiveData = itemDao.getAll()
    }

    fun addItem(item: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val newItem = ItemModel(name = item)
            itemDao.insert(newItem)
        }
    }

    fun removeItem(item: ItemModel) {
        viewModelScope.launch(Dispatchers.IO) {
            itemDao.delete(item)
        }

    }
}