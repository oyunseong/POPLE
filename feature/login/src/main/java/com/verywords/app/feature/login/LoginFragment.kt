package com.verywords.app.feature.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val user = viewModel.user.collectAsState()
                val coroutine = rememberCoroutineScope()
                LoginScreenContent(
                    user = user.value,
                    onLogin = {
                        coroutine.launch {
                            viewModel.requestSignIn()
                        }
                    },
                    onLogout = {
                        coroutine.launch {
                            viewModel.requestSignOut()
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun LoginScreen() {
//    LoginScreenContent()
}

@Composable
fun LoginScreenContent(
    user: String,
    onLogin: () -> Unit,
    onLogout: () -> Unit
) {
    Box(modifier = Modifier) {
        Column {
            Button(onClick = { onLogin.invoke() }) {
                Text(text = "로그인")
            }
            Button(onClick = { onLogout.invoke() }) {
                Text(text = "로그아웃")
            }
            Text(text = "유저 정보 : $user")
        }
    }
}