package com.elitebreeds.pigeonsdate.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//hello 1.5M

@Database(entities = [DatabasePigeon::class], version = 1)
abstract class PigeonDatabase : RoomDatabase() {
    abstract val pigeonDao: Dao
}

private lateinit var INSTANCE: PigeonDatabase

fun getPigeonDB(context: Context) = synchronized(PigeonDatabase::class.java) {
    if (!::INSTANCE.isInitialized) {
        INSTANCE =
            Room.databaseBuilder(context.applicationContext, PigeonDatabase::class.java, "pigeons")
                .build()
    }
}