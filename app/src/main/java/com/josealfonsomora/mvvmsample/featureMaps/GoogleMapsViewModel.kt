package com.josealfonsomora.mvvmsample.featureMaps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.josealfonsomora.mvvmsample.featureJobs.models.JobPosition
import com.josealfonsomora.mvvmsample.repositories.Coordinate
import com.josealfonsomora.mvvmsample.repositories.MapLocationRepositoy
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class GoogleMapsViewModel(
    val mapLocationRepositoy: MapLocationRepositoy,
    val ioScheduler: Scheduler = Schedulers.io(),
    val uiScheduler: Scheduler = AndroidSchedulers.mainThread(),
) : ViewModel(){

    private val listMutableLiveData = MutableLiveData<List<Coordinate>>()
    val listLiveData: LiveData<List<Coordinate>>
        get() = listMutableLiveData
}
