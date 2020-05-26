package com.josealfonsomora.mvvmsample.services

import com.josealfonsomora.mvvmsample.network.RemoteOKResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteOkService {
    @GET("/api")
    fun getJobs(): Single<List<RemoteOKResponse>>
}
