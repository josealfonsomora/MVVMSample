package com.josealfonsomora.mvvmsample.featureMaps.di

import com.josealfonsomora.mvvmsample.featureMaps.GoogleMapsViewModel
import com.josealfonsomora.mvvmsample.repositories.MapLocationRepositoy
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun provideGoogleMapsModule() = module {
    single { MapLocationRepositoy() }

    viewModel {
        GoogleMapsViewModel()
    }
}
