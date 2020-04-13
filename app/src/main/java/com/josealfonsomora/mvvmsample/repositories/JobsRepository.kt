package com.josealfonsomora.mvvmsample.repositories

import com.josealfonsomora.mvvmsample.featureJobs.RemoteOkApi
import com.josealfonsomora.mvvmsample.featureJobs.models.JobPosition

class JobsRepository(private val remoteOkService: RemoteOkApi) {
    fun getJobs() =
        remoteOkService
            .getJobs()
            .map { list -> list.filterIsInstance<JobPosition>().sortedByDescending { it.epoch } }
}
