package com.josealfonsomora.mvvmsample.featureJobs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.josealfonsomora.mvvmsample.core.extensions.disposeWith
import com.josealfonsomora.mvvmsample.featureJobs.models.JobPosition
import com.josealfonsomora.mvvmsample.repositories.JobsRepository
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class JobsViewModel(
    jobsRepository: JobsRepository,
    ioScheduler: Scheduler = Schedulers.io()
) : ViewModel() {
    private val disposables = CompositeDisposable()

    private val listMutableLiveData = MutableLiveData<List<JobPosition>>()
    val listLiveData: LiveData<List<JobPosition>>
        get() = listMutableLiveData

    init {
        jobsRepository
            .getJobs()
            .subscribeOn(ioScheduler)
            .subscribe(
                {
                    listMutableLiveData.postValue(it)
                },
                {
                    // TODO: Present a nice error
                })
            .disposeWith(disposables)
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }
}
