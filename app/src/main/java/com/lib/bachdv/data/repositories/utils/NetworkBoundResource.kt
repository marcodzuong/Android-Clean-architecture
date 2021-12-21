package com.lib.bachdv.data.repositories.utils

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

abstract class NetworkBoundResource<ResultType, RequestType> {

    private val _result = MutableLiveData<Resource<ResultType>>()
    private lateinit var _subscriptions: CompositeDisposable
    fun build(subscriptions: CompositeDisposable): NetworkBoundResource<ResultType, RequestType> {
        _subscriptions = subscriptions
        setValue(Resource.loading(null))
        fetchFromNetwork()
        return this
    }

    fun asLiveData() = _result as LiveData<Resource<ResultType>>

    private fun fetchFromNetwork() {
        _subscriptions.add(
            createCallAsync()
                .subscribeOn(Schedulers.io())
                .map { res: RequestType ->
                    processResponse(res)
                }.observeOn(AndroidSchedulers.mainThread())
                .subscribe({ res: ResultType ->
                    setValue(Resource.success(res))
                }, {
                    setValue(Resource.error(it, null))
                })
        )
    }

    @MainThread
    private fun setValue(newValue: Resource<ResultType>) {
        if (_result.value != newValue) _result.postValue(newValue)
    }

    protected abstract fun createCallAsync(): Observable<RequestType>

    protected abstract fun processResponse(response: RequestType): ResultType



}