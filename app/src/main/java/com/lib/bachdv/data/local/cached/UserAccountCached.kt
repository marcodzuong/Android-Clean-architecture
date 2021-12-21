package com.lib.bachdv.data.local.cached

import android.content.Context

class UserAccountCached(context: Context) : AppCached(context) {

    override fun getKeyShare(): String = "UserAccountCached"

    var isLike: Boolean
        set(value) {
            sharedPrefs.setBooleanPreference("is_like", value)
        }
        get() {
            return sharedPrefs.getBooleanPreference("is_like", false)
        }
}