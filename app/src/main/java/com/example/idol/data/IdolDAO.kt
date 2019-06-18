package com.example.idol.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.idol.data.Idol

@Dao
interface IdolDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(idol: Idol)

    @Query("SELECT * FROM idols")
    fun getAllIdols(): LiveData<List<Idol>>

    @Query("SELECT * FROM idols WHERE id=:idIdol")
    fun getIdol(idIdol:Int): LiveData<Idol>

    @Query("DELETE FROM idols")
    fun deleteAllIdols()
}