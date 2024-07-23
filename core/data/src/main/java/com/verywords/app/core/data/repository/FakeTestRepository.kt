package com.verywords.app.core.data.repository

import com.verywords.app.core.data.api.TestApi
import com.verywords.app.core.data.mapper.toData
import com.verywords.app.core.data.repository.api.TestRepository
import com.verywords.app.core.model.Test
import javax.inject.Inject


internal class FakeTestRepository @Inject constructor(
    private val testApi: TestApi
) : TestRepository {

    override suspend fun getTestData(): List<Test> {
        return testApi.getCsList().map { it.toData() }
    }
}