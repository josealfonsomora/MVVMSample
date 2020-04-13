package com.josealfonsomora.mvvmsample.featureJobs.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.parseAsHtml
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.josealfonsomora.mvvmsample.R
import com.josealfonsomora.mvvmsample.databinding.ItemJobPositionBinding
import com.josealfonsomora.mvvmsample.featureJobs.models.JobPosition
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class JobPositionItemAdapter : RecyclerView.Adapter<JobPositionItemAdapter.ViewHolder>() {
    private val items = mutableListOf<JobPosition>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemJobPositionBinding>(
            inflater, R.layout.item_job_position, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            company.text = item.company
            role.text = item.position
            tags.text = item.tags?.joinToString()
            description.text = item.description?.parseAsHtml()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                item.epoch?.let {
                    val formattedDate = LocalDateTime.ofEpochSecond(item.epoch, 0, ZoneOffset.UTC)
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    date.text = "Published: $formattedDate"
                }
            } else {
                date.text = "Published: ${item.date}"
            }
            Glide.with(image.context).load(item.companyLogo).centerCrop().into(image)
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

    fun updatePosterList(posters: List<JobPosition>) {
        items.clear()
        items.addAll(posters)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemJobPositionBinding) : RecyclerView.ViewHolder(binding.root)
}
