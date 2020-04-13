package com.josealfonsomora.mvvmsample.network

import com.google.gson.annotations.SerializedName

interface JobsApiResponseObject

data class JobListOkLegal(@SerializedName("legal") val legalText: String) : JobsApiResponseObject
