package com.lib.bachdv.di

import com.lib.bachdv.data.api.di.createRetrofitModule
import com.lib.bachdv.data.local.di.localModule
import com.lib.bachdv.data.repositories.di.repositoryModule
import com.lib.bachdv.presentation.di.presentationModule

val appComponent = listOf(
    localModule,
    repositoryModule,
    presentationModule,
    createRetrofitModule("https://dev-api.funtoon.vn")
)