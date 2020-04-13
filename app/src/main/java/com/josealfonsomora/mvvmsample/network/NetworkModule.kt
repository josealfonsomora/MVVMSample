package com.josealfonsomora.mvvmsample.network

import android.util.Log
import com.google.gson.GsonBuilder
import com.josealfonsomora.mvvmsample.BuildConfig
import com.josealfonsomora.mvvmsample.core.deserializers.JobsApiResponseDeserializer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Koin module for Network dependencies like Retrofit or OkHttp
 */
fun provideNetworkModule() = module {

    single { RxJava2CallAdapterFactory.create() }

    single {
        GsonBuilder()
            .registerTypeAdapter(JobsApiResponseObject::class.java, JobsApiResponseDeserializer())
            .create()
    }

    single {
        HttpLoggingInterceptor { message ->
            Log.d("Retrofit logging", message)
        }.apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }
    single {
        OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        GsonConverterFactory.create(get())
    }

    single {
        Retrofit.Builder()
            .addConverterFactory(get<GsonConverterFactory>())
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
            .client(get<OkHttpClient>())
    }

}
