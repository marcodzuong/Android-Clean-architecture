package com.lib.bachdv.data.api

import com.lib.bachdv.data.api.entity.ComicDetailEntity
import com.lib.bachdv.data.api.utils.BaseResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("v1/comics")
    fun getComicDetail(): Observable<BaseResponse<ComicDetailEntity>>
}