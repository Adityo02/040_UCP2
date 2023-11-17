package com.example.exercise2.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercise2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    onSubmitButtonClick: (MutableList<String>) -> Unit
){
    Text(
        text = "Formulir Pengajuan Skripsi",
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold
    )
    var namaTxt by rememberSaveable {
        mutableStateOf("")
    }

    var alamatTxt by rememberSaveable {
        mutableStateOf("")
    }

    var telponTxt by rememberSaveable {
        mutableStateOf("")
    }
    var judulTxt by rememberSaveable {
        mutableStateOf("")
    }

    var listDataTxt : MutableList<String> = mutableListOf(namaTxt, alamatTxt, telponTxt, judulTxt)

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ){
        OutlinedTextField(value = namaTxt, onValueChange = {
            namaTxt = it
        }, label = {
            Text(text = "Nama Mahasiswa")
        }
        )
        OutlinedTextField(value = alamatTxt, onValueChange = {
            alamatTxt = it
        }, label = {
            Text(text = "NIM")
        }
        )
        OutlinedTextField(value = telponTxt, onValueChange = {
            telponTxt = it
        }, label = {
            Text(text = "Konsentrasi")
        }
        )
        OutlinedTextField(value = judulTxt, onValueChange = {
            judulTxt = it
        }, label = {
            Text(text = "Judul Skripsi")
        }
        )
        Spacer(modifier = Modifier.padding(16.dp))

        @Composable
        fun SelectJK(
            options: List<String>,
            onSelectionChanged: (String) -> Unit = {}

        ) {
            var selectedValue by remember { mutableStateOf(" ") }

            Row(modifier = Modifier.padding(16.dp)){
                options.forEach{ item ->
                    Row(
                        modifier = Modifier.selectable(
                            selected = selectedValue ==item,
                            onClick = {
                                selectedValue = item
                                onSelectionChanged(item)
                            }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        RadioButton(selected = selectedValue == item, onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        }
                        )
                        Text(item)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.padding(16.dp))

        Button(onClick =  {onSubmitButtonClick(listDataTxt)} ) {
            Text(text = stringResource(R.string.btn_submit))
        }

    }
}