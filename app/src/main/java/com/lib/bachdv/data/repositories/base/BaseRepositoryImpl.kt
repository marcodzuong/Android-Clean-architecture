package com.lib.bachdv.data.repositories.base

import io.reactivex.disposables.CompositeDisposable

open class BaseRepositoryImpl {
    private var _composite: CompositeDisposable? = null
    protected fun initComposite(): CompositeDisposable {
        if (_composite == null) {
            _composite = CompositeDisposable()
        }
        return _composite!!
    }
    fun onClear() {
        _composite?.clear()
        _composite = null
    }
}