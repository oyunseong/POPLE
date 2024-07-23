package com.verywords.app.core.model

data class Test(
    val id: String,
    val status: String,
    val title: String,
    val writer: String,
    val reporter: String?,
    val registrationDate: Long,
    val completeDate: Long,
    val preferredStation: String
)


