package com.example.exercise2.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.exercise2.data.DataForm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CobaViewModel: ViewModel() {
    var namaUsr : String by mutableStateOf("") //revised
        private set
    var noTlp : String by mutableStateOf("")
        private set
    var jenisKl : String by mutableStateOf("")
        private set
    var statusnkh : String by mutableStateOf("")
        private set
    var alamat : String by mutableStateOf("")
        private set
    var demail : String by mutableStateOf("")
        private set
    private val _uiState = MutableStateFlow(DataForm())
    val uiState: StateFlow<DataForm> = _uiState.asStateFlow()

    fun BacaData(nm:String, tlp:String, jk:String, almt:String, eml:String, stts:String){
        namaUsr=nm;
        noTlp=tlp;
        jenisKl=jk;
        statusnkh=stts;
        alamat=almt;
        demail=eml;
    }

    fun setJenisK(pilihJK:String){
        _uiState.update { currentState -> currentState.copy(sex = pilihJK) }
    }
    fun set(pilihstts:String){
        _uiState.update { currentState -> currentState.copy(stts = pilihstts) }
    }
}