package com.josealfonsomora.mvvmsample.di

import com.josealfonsomora.mvvmsample.SampleMVVMApplication
import com.josealfonsomora.mvvmsample.featureJobs.provideJobsModule
import com.josealfonsomora.mvvmsample.network.provideNetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Extension function to start koin dependency injector
 * This function
 */
fun SampleMVVMApplication.setupKoin() {
    startKoin {
        androidLogger()
        androidContext(this@setupKoin)
        modules(
            listOf(
                provideCoreModule(),
                provideNetworkModule(),
                provideJobsModule()
            )
        )
    }
}
