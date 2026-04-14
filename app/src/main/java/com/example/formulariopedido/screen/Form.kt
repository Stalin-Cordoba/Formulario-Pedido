package com.example.formulariopedido.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
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
    val telefonoError = telefono.length != 8
    val direccionError = direccion.length < 10
    val productoError = producto.length < 5
    val cantError = cantidad.toIntOrNull()!! <= 0 // Evita que la cantidad insertada sea negativa

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

            // Cuadro de texto para: Teléfono
            Row(modifier = modifier.padding(4.dp)){
                Text(text = "Teléfono:")
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedTextField(value = telefono,
                    onValueChange = {telefono = it},
                    isError = telefonoError,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Cuadro de texto para: Dirección
            Row(modifier = modifier.padding(4.dp)){
                Text(text = "Dirección:")
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedTextField(value = direccion, onValueChange = {direccion = it}, isError = direccionError)
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Cuadro de texto para: Producto
            Row(modifier = modifier.padding(4.dp)){
                Text(text = "Producto:")
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedTextField(value = producto, onValueChange = {producto = it}, isError = productoError)
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Cuadro de texto para: Cantidad
            Row(modifier = modifier.padding(4.dp)){
                Text(text = "Cantidad:")
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedTextField(value = cantidad,
                    onValueChange = {cantidad = it},
                    isError = cantError,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Cuadro de texto para: Notas
            Row(modifier = modifier.padding(4.dp)){
                Text(text = "Notas:")
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedTextField(value = notas, onValueChange = {notas = it})
            }
        }
    }
}