package com.josealfonsomora.mvvmsample.featureJobs.di

import com.josealfonsomora.mvvmsample.featureJobs.viewmodels.JobsViewModel
import com.josealfonsomora.mvvmsample.repositories.JobsRepository
import com.josealfonsomora.mvvmsample.services.GithubService
import com.josealfonsomora.mvvmsample.services.RemoteOkService
import com.josealfonsomora.mvvmsample.services.RemotiveService
import com.josealfonsomora.mvvmsample.services.StackOverflowService
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

fun provideJobsModule() = module {
    single(named("base_url")) { }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .addConverterFactory(get<GsonConverterFactory>())
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
            .baseUrl("https://remoteok.io")
            .build()
            .create(RemoteOkService::class.java) as RemoteOkService
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .addConverterFactory(get<GsonConverterFactory>())
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
            .baseUrl("https://remotive.io/")
            .build()
            .create(RemotiveService::class.java) as RemotiveService
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
            .baseUrl("https://stackoverflow.com")
            .build()
            .create(StackOverflowService::class.java) as StackOverflowService
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .addConverterFactory(get<GsonConverterFactory>())
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
            .baseUrl("https://jobs.github.com/")
            .build()
            .create(GithubService::class.java) as GithubService
    }

    single { JobsRepository(get(), get(), get(), get()) }

    viewModel {
        JobsViewModel(
            get()
        )
    }

}
