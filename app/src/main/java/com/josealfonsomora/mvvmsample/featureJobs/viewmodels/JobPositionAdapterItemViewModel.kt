package com.josealfonsomora.mvvmsample.featureJobs.viewmodels

import androidx.core.text.parseAsHtml
import com.josealfonsomora.mvvmsample.featureJobs.models.JobPosition
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class JobPositionAdapterItemViewModel(private val item: JobPosition) {
    val description = item.description?.parseAsHtml()
    val company = item.company
    val role = item.position
    val tags = item.tags?.joinToString()
    var date: String

    init {
        val dateTime = LocalDateTime.ofInstant(item.epoch?.let { Instant.ofEpochSecond(it) }, ZoneOffset.UTC)
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        date = dateTime.format(formatter)
    }
}
