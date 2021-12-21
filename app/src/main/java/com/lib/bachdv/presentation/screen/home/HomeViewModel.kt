package com.lib.bachdv.presentation.screen.home

import androidx.lifecycle.ViewModel
import com.lib.bachdv.data.repositories.base.BaseRepositoryImpl
import com.lib.bachdv.domain.repositories.IComicDetailRepository

class HomeViewModel(private val repository: IComicDetailRepository) : ViewModel() {
    fun hello(){

    }
    fun getComicDetail(){
        val response = repository.getComicDetail()
    }
    override fun onCleared() {
        super.onCleared()
        if (repository is BaseRepositoryImpl){
            repository.onClear()
        }
    }
}