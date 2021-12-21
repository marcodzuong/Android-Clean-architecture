package com.lib.bachdv.domain.repositories

import androidx.lifecycle.LiveData
import com.lib.bachdv.data.repositories.utils.Resource
import com.lib.bachdv.domain.entity.ComicDetail

interface IComicDetailRepository {
    fun getComicDetail() : LiveData<Resource<ComicDetail>>
}