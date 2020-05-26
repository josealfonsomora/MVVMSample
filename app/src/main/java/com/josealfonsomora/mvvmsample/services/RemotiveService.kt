package com.josealfonsomora.mvvmsample.services

import com.josealfonsomora.mvvmsample.network.RemotiveResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RemotiveService{

    @GET("/api/remote-jobs")
    fun getJobs(): Single<RemotiveResponse>
}
