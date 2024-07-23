package com.verywords.app.core.data.di

import com.verywords.app.core.data.api.TestApi
import com.verywords.app.core.data.repository.FakeTestRepository
import com.verywords.app.core.data.repository.api.TestRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
internal object DataModule {
    @Provides
    @Singleton
    fun provideTestRepository(
        testApi: TestApi,
    ): TestRepository = FakeTestRepository(testApi)
}