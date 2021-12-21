package com.lib.bachdv.data.local.di

import com.lib.bachdv.data.local.cached.UserAccountCached
import com.lib.bachdv.data.local.db.ProjectDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module


val localModule = module {
    single(name = "DATABASE") { ProjectDatabase.buildDatabase(androidContext()) }
    factory { (get("DATABASE") as ProjectDatabase).searchDao() }
    single { UserAccountCached(androidContext()) }

}