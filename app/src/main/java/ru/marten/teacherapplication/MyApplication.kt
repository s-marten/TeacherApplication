package ru.marten.teacherapplication

import android.app.Application
import androidx.room.Room
import ru.marten.teacherapplication.data.database.AppDataBase

class MyApplication : Application() {

    private var _database: AppDataBase? = null

    val database: AppDataBase
        get() = _database!!

    override fun onCreate() {
        super.onCreate()
        _database = Room.databaseBuilder(
            this,
            AppDataBase::class.java,
            "app_database"
        ).build()
    }

    var counter: Int = 0

}