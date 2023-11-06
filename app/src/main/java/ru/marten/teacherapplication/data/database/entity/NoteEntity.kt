package ru.marten.teacherapplication.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey
    val id: Long?,
    @ColumnInfo(name = "data")
    val data: String?
)
