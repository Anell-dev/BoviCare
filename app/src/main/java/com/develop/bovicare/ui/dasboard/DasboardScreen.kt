package com.develop.bovicare.ui.dasboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.develop.bovicare.R

@Preview(showBackground = true)
@Composable
fun DasboardScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Dasboard()
    }
}


@Composable
fun Dasboard() {
    Column(
        // Modificadores
    ) {
        headerNav()
        // Esto hara scroll cualquier caso se pase del tamaño hay que agregar
        // Un tamaño fijo o si no tomara el tamaño max de la pantalla del telefono
        LazyColumn(modifier = Modifier.background(Color.White)) {
            item {
                actionBoviCare()

            }
        }

    }
}


@Composable
fun actionBoviCare() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp)
        ) {
            Text(text = "Acciones", color = Color.Black)
            Image(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "rightarrow",
                modifier = Modifier
                    .padding(start = 2.dp)
                    .size(15.dp)
            )
        }

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(5) { index ->
                ContainerButtons(
                    imageRes = when (index) {
                        // Aqui pongo las imagenes
                        0 -> R.drawable.baked_goods_1
                        1 -> R.drawable.baked_goods_2
                        2 -> R.drawable.baked_goods_3
                        3 -> R.drawable.baked_goods_1
                        4 -> R.drawable.baked_goods_1
                        else -> R.drawable.baked_goods_1 // Imagen por defecto
                    },
                    text = when (index) {
                        0 -> "Animales"
                        1 -> "Desparacitaciones"
                        2 -> "Vacunas"
                        3 -> "Enfermedades"
                        4 -> "Tratamientos"
                        else -> "Acción"
                    },
                    onClick = {
                        // Ejecutar una función específica según el índice
                        when (index) {
                            0 -> openAnimalActivity()
                            1 -> openDesparacitacionesActivity()
                            2 -> openVacunasActivity()
                            // Solo Animales se va usar si queremos crecer la app
                            // Vamos a usar un gestor de (vacunas , despasitadores , entre otros)
                        }
                    }
                )
            }
        }
    }
}

fun openVacunasActivity() {
    // Opcional : Gestor de Vacunas
}

fun openDesparacitacionesActivity() {
    // Opcional : Gestor de Desparacitaciones
}

fun openAnimalActivity() {
    // Logica para el registro de animales (Esto se utilizara)

    // eDWIN PARTE REGISTRO
}

@Composable
fun ContainerButtons(imageRes: Int, text: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = text,
            modifier = Modifier
                .size(85.dp)
                .padding(top = 10.dp)
                .clickable { onClick() }
        )
        Text(
            text = text,
            fontSize = 12.sp, color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(5.dp)
        )
    }
}

@Composable
fun headerNav() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFCE200))
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Bovi Care", color = Color.Black,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


