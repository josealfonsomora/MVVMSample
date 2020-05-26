package com.josealfonsomora.mvvmsample.featureJobs

import com.josealfonsomora.mvvmsample.featureJobs.viewmodels.JobsViewModel
import com.josealfonsomora.mvvmsample.repositories.JobsRepository
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.schedulers.Schedulers
import org.junit.Test

class JobsViewModelTest {

    private val jobsRepository: JobsRepository = mock()

    private val jobsViewModel =
        JobsViewModel(
            jobsRepository = jobsRepository,
            ioScheduler = Schedulers.trampoline()
        )

    @Test
    fun updatesLiveDataWithJobsFromRepository() {
    }
}
