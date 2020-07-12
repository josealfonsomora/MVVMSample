package com.josealfonsomora.mvvmsample.repositories

import com.josealfonsomora.mvvmsample.services.GithubService
import com.josealfonsomora.mvvmsample.services.RemoteOkService
import com.josealfonsomora.mvvmsample.services.RemotiveService
import com.josealfonsomora.mvvmsample.services.StackOverflowService
import com.nhaarman.mockitokotlin2.mock
import org.junit.Test

class JobsRepositoryTest {

    private val remoteOkService: RemoteOkService = mock()
    private val stackOverflowService: StackOverflowService = mock()
    private val remotiveService: RemotiveService = mock()
    private val githubService: GithubService = mock()

    private val jobsRepository = JobsRepository(
        remoteOkService = remoteOkService,
        stackOverflowService = stackOverflowService,
        githubService = githubService,
        remotiveService = remotiveService
    )

    @Test
    fun retrievesJobsFromSources() {

    }
}
