package com.verywords.app.core.data.repository.api

import com.verywords.app.core.model.Test

interface TestRepository {

    suspend fun getTestData() : List<Test>
}