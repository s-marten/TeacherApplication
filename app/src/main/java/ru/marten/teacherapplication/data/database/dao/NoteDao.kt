package ru.marten.teacherapplication.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.marten.teacherapplication.data.database.entity.NoteEntity

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: NoteEntity)

    @Query("SELECT * FROM note")
    fun getAll(): List<NoteEntity>
}