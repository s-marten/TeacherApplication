package ru.marten.teacherapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.marten.teacherapplication.data.database.dao.NoteDao
import ru.marten.teacherapplication.data.database.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun noteDao(): NoteDao
}