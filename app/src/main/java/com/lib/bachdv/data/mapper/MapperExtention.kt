package com.lib.bachdv.data.mapper

import com.lib.bachdv.data.api.entity.ComicDetailEntity
import com.lib.bachdv.domain.entity.ComicDetail

fun ComicDetailEntity.toComicDetail(): ComicDetail {
    return ComicDetail()
}