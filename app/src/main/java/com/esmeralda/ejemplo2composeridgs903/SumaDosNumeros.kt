package com.esmeralda.ejemplo2composeridgs903


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun SumaDosNumeros() {

    val radioOptions = listOf("Suma", "Resta", "Multiplicacion", "Division")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    var num1 by remember()  { mutableStateOf("") }
    var num2 by remember() { mutableStateOf("")}
    var resulado by remember() { mutableStateOf("") }

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ){
        TextField(
            value = num1,
            onValueChange = {num1 = it},
            label = {Text("Número 1")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = num2,
            onValueChange = {num2 = it},
            label = {Text("Número 2")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        val option = RadioButtonSingleSelection()
        Button(onClick = {

            val n1 = num1.toIntOrNull()
            val n2 = num2.toIntOrNull()

            if(option == "Suma") {
                resulado = if (n1 != null && n2 != null) {
                    "Resultado: ${n1 + n2}"
                } else {
                    "Ingrese números validos"
                }
            }

            if(option == "Resta"){
                resulado = if (n1 != null && n2 != null) {
                    "Resultado: ${n1 - n2}"
                } else {
                    "Ingrese números validos"
                }
            }
            if(option == "Multiplicacion"){
                resulado = if (n1 != null && n2 != null) {
                    "Resultado: ${n1 * n2}"
                } else {
                    "Ingrese números validos"
                }
            }
            if(option == "Division"){
                resulado = if (n1 != null && n2 != null) {
                    "Resultado: ${n1 / n2}"
                } else {
                    "Ingrese números validos"
                }
            }
        }) {
            Text("Resultado")
        }
        Text(text = resulado)


    }


}

@Composable
fun RadioButtonSingleSelection(modifier: Modifier = Modifier): String {
  val radioOptions = listOf("Suma", "Resta", "Multiplicacion", "Division")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    Column(modifier.selectableGroup()) {
        radioOptions.forEach{ text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text)},
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

        }

    }
    return selectedOption
}

