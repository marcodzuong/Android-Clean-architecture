package com.lib.bachdv.presentation.di

import com.lib.bachdv.presentation.screen.home.HomeViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val presentationModule = module {
    viewModel { HomeViewModel(get ()) }
}