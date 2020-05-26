package com.josealfonsomora.mvvmsample.network

import com.google.gson.annotations.SerializedName

class GithubResponse(
    val id: String,
    val type: String,
    val url: String,
    @SerializedName("created_at") val createdAt: String, // "Sat Aug 03 00:50:23 UTC 2019"
    val company: String,
    val location: String,
    val title: String,
    val description: String,
    @SerializedName("how_to_apply") val howToApply: String,
    @SerializedName("company_logo") val companyLogo: String
): JobServiceResponse
