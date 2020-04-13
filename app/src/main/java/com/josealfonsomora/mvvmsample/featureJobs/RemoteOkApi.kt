package com.josealfonsomora.mvvmsample.featureJobs

import com.josealfonsomora.mvvmsample.network.JobsApiResponseObject
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteOkApi {
    @GET("/api")
    fun getJobs(): Single<List<JobsApiResponseObject>>
}
