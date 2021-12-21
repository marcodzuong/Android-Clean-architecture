package com.lib.bachdv.data.local.cached

import android.content.Context
import android.content.SharedPreferences

abstract class AppCached(context: Context) {
    private val _context: Context = context
    protected var sharedPrefs: SharedPreferencesImpl
    private lateinit var _preferences: SharedPreferences
    private fun initPrefs(key: String): SharedPreferences {
        _preferences=   _context.getSharedPreferences(key, Context.MODE_PRIVATE)
        return _preferences
    }

    abstract fun getKeyShare(): String

    init {
        sharedPrefs = SharedPreferencesImpl.newInstance(initPrefs(getKeyShare()))
    }

}