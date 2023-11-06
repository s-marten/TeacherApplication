package ru.marten.teacherapplication.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.marten.teacherapplication.MyApplication
import ru.marten.teacherapplication.data.repository.DataBaseRepository
import ru.marten.teacherapplication.data.repository.DataStoreRepository
import ru.marten.teacherapplication.data.repository.SaveDataRepository
import ru.marten.teacherapplication.data.repository.SharedPrefsRepository

class SaveDataViewModel(context: Context) : ViewModel() {

    private val sharedPrefsRepository: SaveDataRepository

    private val dataStoreRepository: SaveDataRepository

    private val dataBaseRepository: SaveDataRepository

    val data = MutableLiveData<String>()

    init {
        sharedPrefsRepository = SharedPrefsRepository(context)
        dataStoreRepository = DataStoreRepository(context)
        dataBaseRepository = DataBaseRepository(
            (context.applicationContext as MyApplication).database.noteDao()
        )
    }

    fun save(saveTo: String, data: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getRepositoryByType(saveTo).saveData(data)
        }
    }

    fun read(readFrom: String) {
        viewModelScope.launch(Dispatchers.IO) {
            data.postValue(getRepositoryByType(readFrom).readData())
        }
    }

    private fun getRepositoryByType(repoType: String): SaveDataRepository =
        when (repoType) {
            SHARED_PREFS -> sharedPrefsRepository
            DATA_STORE -> dataStoreRepository
            DATA_BASE -> dataBaseRepository
            else -> sharedPrefsRepository
        }

    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val DATA_STORE = "data_store"
        const val DATA_BASE = "database"
    }
}