package com.josealfonsomora.mvvmsample.featureMaps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.josealfonsomora.mvvmsample.R
import com.josealfonsomora.mvvmsample.databinding.ActivityGoogleMapsBinding
import com.josealfonsomora.mvvmsample.repositories.MapLocationRepositoy
import io.reactivex.disposables.CompositeDisposable
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class GoogleMapsActivity : ComponentActivity() {

    private val disposables = CompositeDisposable()

    private lateinit var binding: ActivityGoogleMapsBinding

    private val viewModel: GoogleMapsViewModel by viewModel()

    private val respository: MapLocationRepositoy by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_google_maps)
        binding.model = viewModel

        binding.lifecycleOwner = this // for livedata

    }

}
