package ru.marten.teacherapplication.data.repository

interface SaveDataRepository {

    suspend fun saveData(data: String)

    suspend fun readData(): String
}