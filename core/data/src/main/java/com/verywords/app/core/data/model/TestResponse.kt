package com.verywords.app.core.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class TestResponse(
    @SerialName("id") val id: String,
    @SerialName("status") val status: String,
    @SerialName("title") val title: String,
    @SerialName("writer") val writer: String,
    @SerialName("reporter") val reporter: String?,
    @SerialName("registrationDate") val registrationDate: Long,
    @SerialName("completeDate") val completeDate: Long,
    @SerialName("preferredStation") val preferredStation: String
)
