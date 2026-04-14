package com.example.formulariopedido.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Form(modifier : Modifier = Modifier){

    var nombre by remember {mutableStateOf("")}
    var telefono by remember {mutableStateOf("")}
    var direccion by remember {mutableStateOf("")}
    var producto by remember {mutableStateOf("")}
    var cantidad by remember {mutableStateOf("")}
    var notas by remember {mutableStateOf("")}

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val nombreError = nombre.length < 2
    val telefonoError = telefono.length < 7
    val direccionError = direccion.length < 10
    val cantError = cantidad.toIntOrNull() == null

    Scaffold(snackbarHost = {SnackbarHost(snackbarHostState)}){padding ->
        Column(modifier = modifier.padding(32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "FORMULARIO DE PEDIDO",
                fontSize = 28.sp,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(10.dp))

            // Cuadro de texto para: Nombre
            Row(modifier = modifier.padding(4.dp)){
                Text(text = "Nombre:")
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedTextField(value = nombre, onValueChange = {nombre = it}, isError = nombreError)
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Cuadro de texto para: Nombre
            Row(modifier = modifier.padding(4.dp)){
                Text(text = "Teléfono:")
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedTextField(value = telefono, onValueChange = {telefono = it}, isError = telefonoError)
            }
        }
    }
}