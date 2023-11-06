package ru.marten.teacherapplication.data.repository

import android.content.Context

class SharedPrefsRepository(context: Context): SaveDataRepository {

    private val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override suspend fun saveData(data: String) {
        sharedPreferences.edit().apply {
            putString(DATA_KEY, data)
            apply()
        }
    }

    override suspend fun readData(): String = sharedPreferences.getString(DATA_KEY, "").orEmpty()

    companion object {
        private const val PREFS_NAME = "my_settings"
        private const val DATA_KEY = "data"
    }
}