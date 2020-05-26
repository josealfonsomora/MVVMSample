package com.josealfonsomora.mvvmsample.featureJobs.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.josealfonsomora.mvvmsample.R
import com.josealfonsomora.mvvmsample.databinding.ActivityJobsListBinding
import com.josealfonsomora.mvvmsample.featureJobs.viewmodels.JobsViewModel
import com.josealfonsomora.mvvmsample.featureJobs.adapters.JobPositionItemAdapter
import io.reactivex.disposables.CompositeDisposable
import org.koin.android.viewmodel.ext.android.viewModel

class JobsActivity : ComponentActivity() {

    private val disposables = CompositeDisposable()

    private val viewModel: JobsViewModel by viewModel()

    private lateinit var binding: ActivityJobsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_jobs_list)
        binding.lifecycleOwner = this
        binding.recyclerView.adapter = JobPositionItemAdapter()
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        binding.model = viewModel

        binding.reload.setOnClickListener {
            viewModel.download()
        }
    }

    override fun onStop() {
        super.onStop()
        disposables.dispose()
    }
}
