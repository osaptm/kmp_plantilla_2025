package com.gonzapolleria.kmp2025.pushnotificactions

import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.ViewModel
import com.gonzapolleria.kmp2025.example_ktor_coil.ScreenState
import com.mmk.kmpnotifier.notification.NotifierManager
import kotlinx.coroutines.flow.StateFlow

data class PushUiState(
    var title: String = "",
    var content: String = "",
)

class PushScreenModel : ViewModel() {
    private val _state = MutableStateFlow<PushUiState>(PushUiState())
    val state: StateFlow<PushUiState> = _state


   
    fun onTitleChange(value: String) {
        _state.value = _state.value.copy(title = value)
    }

    fun onContentChange(value: String) {
        _state.value = _state.value.copy(content = value)
    }

    fun sendNotification() {
        val notifier = NotifierManager.getLocalNotifier()
        val currentState = state.value
        notifier.notify(currentState.title, currentState.content)
    }
}
