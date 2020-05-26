package com.josealfonsomora.mvvmsample.services

import com.josealfonsomora.mvvmsample.network.GithubResponse
import io.reactivex.Single
import retrofit2.http.GET

interface GithubService {
    @GET("/positions.json?&location=remote")
    fun getJobs(): Single<List<GithubResponse>>
}
