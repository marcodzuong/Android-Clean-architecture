package com.lib.bachdv.data.api.utils

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class BaseResponse<T> : Serializable {
    @SerializedName("status")
    @Expose
    var status: Int? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("data")
    @Expose
    var data: T? = null
        private set

    @SerializedName("link")
    @Expose
    var link: String? = null

    @SerializedName("fileResult")
    @Expose
    var fileResult: List<String>? = null
    var page = 0
    var isOffline = false
    var id: String? = null

    fun setData(data: T) {
        this.data = data
    }
}