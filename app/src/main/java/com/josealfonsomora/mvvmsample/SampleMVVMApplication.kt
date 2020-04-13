package com.josealfonsomora.mvvmsample

import android.app.Application
import com.josealfonsomora.mvvmsample.di.setupKoin

class SampleMVVMApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }
}
