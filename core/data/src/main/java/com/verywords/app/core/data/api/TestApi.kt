package com.verywords.app.core.data.api

import com.verywords.app.core.data.model.TestResponse
import retrofit2.http.POST

internal interface TestApi {

    @POST("pw/contents/cs/list")
    suspend fun getCsList(): List<TestResponse>
}