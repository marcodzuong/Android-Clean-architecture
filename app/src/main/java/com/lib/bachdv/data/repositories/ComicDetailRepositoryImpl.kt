package com.lib.bachdv.data.repositories

import androidx.lifecycle.LiveData
import com.lib.bachdv.data.api.ApiService
import com.lib.bachdv.data.api.entity.ComicDetailEntity
import com.lib.bachdv.data.api.utils.BaseResponse
import com.lib.bachdv.data.mapper.toComicDetail
import com.lib.bachdv.data.repositories.base.BaseRepositoryImpl
import com.lib.bachdv.data.repositories.utils.NetworkBoundResource
import com.lib.bachdv.data.repositories.utils.Resource
import com.lib.bachdv.domain.entity.ComicDetail
import com.lib.bachdv.domain.repositories.IComicDetailRepository
import io.reactivex.Observable

class ComicDetailRepositoryImpl(private val apiService: ApiService) : BaseRepositoryImpl(),
    IComicDetailRepository {
    override fun getComicDetail(): LiveData<Resource<ComicDetail>> {
        return object : NetworkBoundResource<ComicDetail, BaseResponse<ComicDetailEntity>>() {
            override fun createCallAsync(): Observable<BaseResponse<ComicDetailEntity>> {
                return apiService.getComicDetail()
            }

            override fun processResponse(response: BaseResponse<ComicDetailEntity>): ComicDetail {
                return response.data?.toComicDetail() ?: ComicDetail()
            }
        }.build(initComposite()).asLiveData()
    }
}