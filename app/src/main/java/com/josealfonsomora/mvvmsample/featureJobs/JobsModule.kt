package com.josealfonsomora.mvvmsample.featureJobs

import com.josealfonsomora.mvvmsample.repositories.JobsRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

fun provideJobsModule() = module {
    single(named("base_url")) { }

    single {
        get<Retrofit.Builder>()
            .baseUrl("https://remoteok.io")
            .build()
            .create(RemoteOkApi::class.java)
    }

    single { JobsRepository(get()) }

    viewModel { JobsViewModel(get()) }

}
