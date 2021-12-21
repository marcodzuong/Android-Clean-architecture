package com.lib.bachdv.presentation.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lib.bachdv.data.repositories.base.BaseRepositoryImpl
import com.lib.bachdv.data.repositories.utils.Resource
import com.lib.bachdv.domain.entity.ComicDetail
import com.lib.bachdv.domain.repositories.IComicDetailRepository

class HomeViewModel(private val repository: IComicDetailRepository) : ViewModel() {
    fun hello(){

    }

    private val _comicRes = MediatorLiveData<ComicDetail>()
    val comicRes : LiveData<ComicDetail> = _comicRes
    private val _loadingLoadComic = MutableLiveData<Boolean>()
    val loadingLoadComic : LiveData<Boolean> = _loadingLoadComic
    private val _errorLoadComic = MutableLiveData<Boolean>()
    val errorLoadComic : LiveData<Boolean> = _errorLoadComic
    
    fun getComicDetail(){
        val response = repository.getComicDetail()
        _comicRes.addSource(response){
            if (it.status == Resource.Status.SUCCESS){
                if (it.data!=null){
                    _comicRes.value = it.data
                }
            }
            _loadingLoadComic.value = it.status == Resource.Status.LOADING
            _errorLoadComic.value = it.status == Resource.Status.ERROR
        }
    }
    override fun onCleared() {
        super.onCleared()
        if (repository is BaseRepositoryImpl){
            repository.onClear()
        }
    }
}