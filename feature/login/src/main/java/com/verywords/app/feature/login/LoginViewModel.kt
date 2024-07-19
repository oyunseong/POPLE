package com.verywords.app.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val googleLoginManager: GoogleLoginManager
) : ViewModel() {
    val user = googleLoginManager.user

    fun requestSignIn() {
        viewModelScope.launch {
            googleLoginManager.requestSignIn()
        }
    }

    fun requestSignOut() {
        viewModelScope.launch {
            googleLoginManager.requestSignOut()
        }
    }
}