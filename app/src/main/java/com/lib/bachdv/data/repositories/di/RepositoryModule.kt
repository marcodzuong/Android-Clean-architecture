package com.lib.bachdv.data.repositories.di

import com.lib.bachdv.data.repositories.ComicDetailRepositoryImpl
import com.lib.bachdv.domain.repositories.IComicDetailRepository
import org.koin.dsl.module.module

val repositoryModule = module {
    factory<IComicDetailRepository> { ComicDetailRepositoryImpl(get()) }
}