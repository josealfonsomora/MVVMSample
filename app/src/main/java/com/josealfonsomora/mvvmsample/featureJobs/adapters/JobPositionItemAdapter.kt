package com.josealfonsomora.mvvmsample.featureJobs.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.josealfonsomora.mvvmsample.BR
import com.josealfonsomora.mvvmsample.R
import com.josealfonsomora.mvvmsample.databinding.ItemJobPositionBinding
import com.josealfonsomora.mvvmsample.featureJobs.models.JobPosition
import com.josealfonsomora.mvvmsample.featureJobs.viewmodels.JobPositionAdapterItemViewModel
import com.josealfonsomora.mvvmsample.network.SourceType

class JobPositionItemAdapter : RecyclerView.Adapter<JobPositionItemAdapter.ViewHolder>() {
    private val items = mutableListOf<JobPosition>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_job_position, parent, false)
        val binding = DataBindingUtil.bind<ItemJobPositionBinding>(rootView)!!
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val viewModel = JobPositionAdapterItemViewModel(item)
        holder.viewModel = viewModel
        holder.binding.apply {
            setVariable(BR.model, viewModel)
            Glide.with(image.context).load(item.companyLogo).centerCrop().into(image)

            source.setImageResource(
                when (item.source) {
                    SourceType.REMOTEOK -> R.drawable.remote_ok_image
                    SourceType.STACKOVERFLOW -> R.drawable.stack_overflow_logo
                    SourceType.GITHUB -> R.drawable.github_logo
                    SourceType.REMOTIVE -> R.drawable.remotive_logo
                }
            )
            root.setOnClickListener {
                description.visibility = if (description.visibility == View.VISIBLE) {
                    View.GONE
                } else {
                    View.VISIBLE
                }
            }
            executePendingBindings()
        }
    }

    fun updateJobsList(jobs: List<JobPosition>) {
        items.clear()
        items.addAll(jobs)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemJobPositionBinding) : RecyclerView.ViewHolder(binding.root) {
        lateinit var viewModel: JobPositionAdapterItemViewModel
    }
}
