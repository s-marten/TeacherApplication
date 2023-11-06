package ru.marten.teacherapplication.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single

class DataStoreRepository(private val context: Context): SaveDataRepository {

    private val DATA_VALUE = stringPreferencesKey(DATA_KEY)

    override suspend fun saveData(data: String) {
        context.dataStore.edit { prefs ->
            prefs[DATA_VALUE] = data
        }
    }

    override suspend fun readData(): String {
        return context.dataStore.data.map { prefs ->
            prefs[DATA_VALUE]
        }.first().orEmpty()
    }

    companion object {
        private const val DATA_KEY = "data"
    }
}