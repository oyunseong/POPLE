package com.verywords.app.feature.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.verywords.app.core.data.repository.api.TestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val googleLoginManager: GoogleLoginManager,
    private val testRepository: TestRepository,
) : ViewModel() {
    val user = googleLoginManager.user

//    val testData: MutableStateFlow<Test>

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

    fun requestTestData() {
        viewModelScope.launch {
            val a = testRepository.getTestData()
            Log.d("++##", "Post 요청 : $a")
        }
    }
}