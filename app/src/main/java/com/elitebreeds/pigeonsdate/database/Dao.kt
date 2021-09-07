package com.elitebreeds.pigeonsdate.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.elitebreeds.pigeonsdate.model.Pigeon

//hello 1.5M

@Dao
interface Dao {

    @Insert
    fun addPigeon(pigeon: DatabasePigeon)

    @Query("SELECT * FROM databasepigeon")
    fun getPigeons(): LiveData<List<DatabasePigeon>>
}