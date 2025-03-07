package com.gonzapolleria.kmp2025.example_ktor_coil

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gonzapolleria.kmp2025.example_ktor_coil.remote.ApiService
import com.gonzapolleria.kmp2025.example_ktor_coil.remote.response.Respuesta
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ScreenViewModel(private val api : ApiService):ViewModel() {
    private val _state = MutableStateFlow<ScreenState>(ScreenState())
    val state: StateFlow<ScreenState> = _state
    init{
        viewModelScope.launch {
            val result: Respuesta = withContext(Dispatchers.IO) {
                api.getMedia()
            }
            _state.value = _state.value.copy(respuesta = result)
        }
    }
}