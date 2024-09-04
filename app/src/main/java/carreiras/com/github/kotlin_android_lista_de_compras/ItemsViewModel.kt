package carreiras.com.github.kotlin_android_lista_de_compras

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemsViewModel : ViewModel() {
    private var items = mutableListOf<ItemModel>()

    val itemsLiveData = MutableLiveData<List<ItemModel>>()


    fun addItem(name: String) {
        val item = ItemModel(
            id = 0,
            name = name,
            onRemove = ::removeItem
        )

        items.add(item)
        itemsLiveData.value = items
    }

    private fun removeItem(item: ItemModel) {
        items.remove(item)
        itemsLiveData.value = items
    }

}