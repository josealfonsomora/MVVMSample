package com.josealfonsomora.mvvmsample.core.deserializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.josealfonsomora.mvvmsample.featureJobs.models.JobPosition
import com.josealfonsomora.mvvmsample.network.JobListOkLegal
import com.josealfonsomora.mvvmsample.network.JobsApiResponseObject
import java.lang.reflect.Type

class JobsApiResponseDeserializer : JsonDeserializer<JobsApiResponseObject> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): JobsApiResponseObject = if (json.asJsonObject.has("legal")) {
        context.deserialize(json, JobListOkLegal::class.java)
    } else {
        context.deserialize(json, JobPosition::class.java)
    }

}
