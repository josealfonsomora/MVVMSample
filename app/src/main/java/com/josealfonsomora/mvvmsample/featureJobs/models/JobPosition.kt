package com.josealfonsomora.mvvmsample.featureJobs.models

import com.google.gson.annotations.SerializedName
import com.josealfonsomora.mvvmsample.network.JobsApiResponseObject

data class JobPosition(
    val slug: String? = null,
    val id: Int? = null,
    val epoch: Long? = null,
    val date: String? = null,
    val company: String? = null,
    @SerializedName("company_logo") val companyLogo: String? = null,
    val position: String? = null,
    val tags: List<String>? = null,
    val description: String? = null,
    val verified: Boolean = false,
    val original: Boolean = false,
    val url: String? = null
) : JobsApiResponseObject
