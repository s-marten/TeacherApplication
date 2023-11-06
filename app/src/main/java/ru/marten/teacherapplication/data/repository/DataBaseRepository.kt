package ru.marten.teacherapplication.data.repository

import ru.marten.teacherapplication.data.database.dao.NoteDao
import ru.marten.teacherapplication.data.database.entity.NoteEntity

class DataBaseRepository(private val noteDao: NoteDao): SaveDataRepository {
    override suspend fun saveData(data: String) {
        noteDao.insertNote(
            NoteEntity(null, data)
        )
    }

    override suspend fun readData(): String = noteDao.getAll().toString()

}