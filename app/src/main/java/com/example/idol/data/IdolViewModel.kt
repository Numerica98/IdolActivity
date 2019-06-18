package com.example.idol.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IdolViewModel (app:Application): AndroidViewModel(app) {
    private val repository: IdolRepository

    init {
        val idolDao = RoomDB.getInstance(app).idolDao()
        repository= IdolRepository(idolDao)
    }

    fun insert(idol: Idol)= viewModelScope.launch(Dispatchers.IO){
        repository.insert(idol)
    }

    fun getAll(): LiveData<List<Idol>> = repository.getAll()

    fun getIdol(idIdol: Int): LiveData<Idol> = repository.getIdol(idIdol)

    fun delete()= repository.delete()

}