package com.lib.bachdv

import android.app.Application
import com.lib.bachdv.di.appComponent
import org.koin.android.ext.android.startKoin

class ProjectApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    private fun configureDi() =
        startKoin(androidContext = this, modules = provideComponent())

    private fun provideComponent() = appComponent
}