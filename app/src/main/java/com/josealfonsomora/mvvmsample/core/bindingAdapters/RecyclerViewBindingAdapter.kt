package com.josealfonsomora.mvvmsample.core.bindingAdapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.josealfonsomora.mvvmsample.featureJobs.adapters.JobPositionItemAdapter
import com.josealfonsomora.mvvmsample.featureJobs.models.JobPosition

@BindingAdapter("list")
fun bindingAdapterList(view: RecyclerView, list: List<JobPosition>?) {
    list?.let { (view.adapter as JobPositionItemAdapter).updateJobsList(it) }
}
