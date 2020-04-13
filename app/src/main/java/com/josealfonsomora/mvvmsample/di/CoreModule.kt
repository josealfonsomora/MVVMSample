package com.josealfonsomora.mvvmsample.di

import com.josealfonsomora.mvvmsample.SampleMVVMApplication
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Koin module for Core dependencies
 */
fun provideCoreModule() = module {
    single { androidApplication() as SampleMVVMApplication }
}
