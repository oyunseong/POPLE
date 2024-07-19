package com.verywords.app.feature.login

import android.content.Context
import android.util.Log
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.PasswordCredential
import androidx.credentials.PublicKeyCredential
import androidx.credentials.exceptions.GetCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class GoogleLoginManager @Inject constructor(
    private val credentialManager: CredentialManager,
    @ApplicationContext private val applicationContext: Context
) {
    val user: MutableStateFlow<String> = MutableStateFlow("")
    val token: MutableStateFlow<GoogleIdTokenCredential?> = MutableStateFlow(null)
    val webClientId = applicationContext.getString(R.string.google_oauth_web_client_id)

    suspend fun requestSignIn(context: Context = applicationContext) {
        val googleIdOptions: GetGoogleIdOption = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(true)
            .setServerClientId(webClientId)
            .setAutoSelectEnabled(true) // 이전에 로그인 한 계정을 확인할 지 정하는 옵션
            .build()

        val request: GetCredentialRequest = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOptions)
            .build()
        try {
            val result = credentialManager.getCredential(
                request = request,
                context = applicationContext.applicationContext
            )
            handleSignIn(result)
        } catch (e: GetCredentialException) {
            e.printStackTrace()
        }
    }

    suspend fun requestSignOut(action: () -> Unit = {}) {
        try {
            credentialManager.clearCredentialState(ClearCredentialStateRequest())
            action.invoke()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun handleSignIn(result: GetCredentialResponse) {
        // Handle the successfully returned credential.
        val credential = result.credential
        user.update {
            credential.toString()
        }
        Log.d("++##", "credential :$credential")
        when (credential) {
            // Passkey credential
            is PublicKeyCredential -> {
                // Share responseJson such as a GetCredentialResponse on your server to
                // validate and authenticate
                val responseJson = credential.authenticationResponseJson
                Log.d("++##", "responseJson :$responseJson")

            }

            // Password credential
            is PasswordCredential -> {
                // Send ID and password to your server to validate and authenticate.
                val username = credential.id
                val password = credential.password

                user.update {
                    "username :$username\npassword : $password"
                }
            }

            // GoogleIdToken credential
            is CustomCredential -> {
                if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                    try {
                        // Use googleIdTokenCredential and extract id to validate and
                        // authenticate on your server.
                        val googleIdTokenCredential = GoogleIdTokenCredential
                            .createFrom(credential.data)
                        token.update { googleIdTokenCredential }
                        Log.d("++##", "token : ${googleIdTokenCredential.idToken}")
                    } catch (e: GoogleIdTokenParsingException) {
                        Log.e("++##", "Received an invalid google id token response", e)
                    }
                } else {
                    // Catch any unrecognized custom credential type here.
                    Log.e("++##", "Unexpected type of credential")
                }
            }

            else -> {
                // Catch any unrecognized credential type here.
                Log.e("++##", "Unexpected type of credential")
            }
        }
    }
}