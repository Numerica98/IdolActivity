package com.example.idol.data

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.idol.data.Idol
import com.example.idol.data.IdolDAO

class IdolRepository (private val idolDao: IdolDAO){

    @WorkerThread
    suspend fun insert(idol: Idol){
        idolDao.insert(idol)
    }

    fun getAll():LiveData<List<Idol>> = idolDao.getAllIdols()

    fun getIdol(idIdol: Int): LiveData<Idol> = idolDao.getIdol(idIdol)

    fun delete() = idolDao.deleteAllIdols()
}