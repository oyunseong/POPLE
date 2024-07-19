package com.verywords.app.feature.login.di

import android.content.Context
import androidx.credentials.CredentialManager
import com.verywords.app.feature.login.GoogleLoginManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class ApplicationScope

    @Provides
    @Singleton
    fun provideApplicationContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideCredentialManager(@ApplicationContext context: Context): CredentialManager {
        return CredentialManager.create(context)
    }

    @Provides
    @Singleton
    fun provideGoogleLoginManager(
        credentialManager: CredentialManager,
        @ApplicationContext applicationContext: Context
    ): GoogleLoginManager {
        return GoogleLoginManager(credentialManager, applicationContext)
    }
}