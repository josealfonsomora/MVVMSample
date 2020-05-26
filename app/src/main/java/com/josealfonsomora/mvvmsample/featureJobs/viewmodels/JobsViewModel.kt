package com.josealfonsomora.mvvmsample.featureJobs.viewmodels

import android.util.Log
import android.view.View
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.josealfonsomora.mvvmsample.core.extensions.disposeWith
import com.josealfonsomora.mvvmsample.featureJobs.models.JobPosition
import com.josealfonsomora.mvvmsample.repositories.JobsRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class JobsViewModel(
    val jobsRepository: JobsRepository,
    val ioScheduler: Scheduler = Schedulers.io()
) : ViewModel() {

    val loadingVisibility = ObservableInt(View.GONE)
    private val disposables = CompositeDisposable()

    private val listMutableLiveData = MutableLiveData<List<JobPosition>>()
    val listLiveData: LiveData<List<JobPosition>>
        get() = listMutableLiveData

    private val jobsRepositoryObservable = jobsRepository
        .getJobs()
        .map { list -> list.sortedByDescending { it.epoch } }
        .map { list ->
            list.filter {
                it.tags?.any { tag -> tag.contains("android", ignoreCase = true) } == true ||
                        it.description?.contains("android", ignoreCase = true) == true ||
                        it.position?.contains("android", ignoreCase = true) == true
            }
        }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }

    fun download() = Observable.just(loadingVisibility.set(View.VISIBLE))
        .switchMapSingle { jobsRepositoryObservable }
        .subscribeOn(ioScheduler)
        .subscribe(
            {
                listMutableLiveData.postValue(it)
                loadingVisibility.set(View.GONE)
            },
            {
                // TODO: Present a nice error
                Log.d("JobsViewModel", it.toString())
            })
        .disposeWith(disposables)

}
