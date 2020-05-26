package com.josealfonsomora.mvvmsample.services

import com.josealfonsomora.mvvmsample.network.StackOverFlowResponseObject
import io.reactivex.Single
import retrofit2.http.GET

interface StackOverflowService{

    @GET("/jobs/feed?location=remote")
    fun getJobs(): Single<StackOverFlowResponseObject>
}
