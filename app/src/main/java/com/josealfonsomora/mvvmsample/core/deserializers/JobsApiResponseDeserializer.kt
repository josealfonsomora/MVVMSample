package com.josealfonsomora.mvvmsample.core.deserializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.josealfonsomora.mvvmsample.featureJobs.models.RemoteOkJobPosition
import com.josealfonsomora.mvvmsample.featureJobs.models.RemoteOkLegalText
import com.josealfonsomora.mvvmsample.network.RemoteOKResponse
import java.lang.reflect.Type

class JobsApiResponseDeserializer : JsonDeserializer<RemoteOKResponse> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): RemoteOKResponse = if (json.asJsonObject.has("legal")) {
        context.deserialize(json, RemoteOkLegalText::class.java)
    } else {
        context.deserialize(json, RemoteOkJobPosition::class.java)
    }

}
