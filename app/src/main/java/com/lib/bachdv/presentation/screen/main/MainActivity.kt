package com.lib.bachdv.presentation.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lib.bachdv.R
import com.lib.bachdv.presentation.screen.home.HomeViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    val viewModel : HomeViewModel by inject<HomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.hello()
    }
}