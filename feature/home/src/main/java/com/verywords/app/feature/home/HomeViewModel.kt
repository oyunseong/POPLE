package com.verywords.app.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    val cnt: MutableStateFlow<Int> = MutableStateFlow(0)

    fun plusCnt() {
        viewModelScope.launch {
            cnt.emit(cnt.value + 1)
        }
    }

    override fun onCleared() {
        super.onCleared()

        Log.d("++##", "HomeViewModel onCleared()")
    }
}