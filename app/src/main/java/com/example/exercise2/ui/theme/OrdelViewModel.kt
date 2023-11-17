package com.example.exercise2.ui.theme

import androidx.lifecycle.ViewModel
import com.example.exercise2.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrdelViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI: StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun resetOrder(){
        _stateUI.value = OrderUIState()
    }
    fun setContact(ListData: MutableList<String>){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = ListData[0],
                alamat = ListData[1],
                telpon = ListData[2],
                judul = ListData[3]
            )
        }
    }
}