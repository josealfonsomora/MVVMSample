package com.josealfonsomora.mvvmsample.featureJobs.models

import com.josealfonsomora.mvvmsample.network.SourceType

data class JobPosition(
    val id: Int? = null,
    val epoch: Long? = null,
    val date: String? = null,
    val company: String? = null,
    val companyLogo: String? = null,
    val position: String? = null,
    val tags: List<String>? = null,
    val description: String? = null,
    val url: String? = null,
    val source: SourceType
)
