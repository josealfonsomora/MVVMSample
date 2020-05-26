package com.josealfonsomora.mvvmsample.featureJobs.models

import com.google.gson.annotations.SerializedName
import com.josealfonsomora.mvvmsample.network.RemoteOKResponse

data class RemoteOkLegalText(@SerializedName("legal") val legalText: String) : RemoteOKResponse
