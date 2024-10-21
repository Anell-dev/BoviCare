package com.develop.bovicare.ui.dasboard

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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

// al usar el clcik de flecha en acciones
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import com.develop.bovicare.ui.home.CopyRightScreen
import kotlinx.coroutines.launch

@Preview
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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp)
        ) {
            headerNav()

            LazyColumn(modifier = Modifier.background(Color.White)) {
                item {
                    actionBoviCare()
                    updateSetionBoviCare()

                    // Para hacer prueba del scroll
                    //updateSetionBoviCare()
                    //updateSetionBoviCare()
                }
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) { Column (){
            buttonNavigationBoviCare()
            CopyRightScreen()
        }
        }

    }
}

@Composable
fun buttonNavigationBoviCare() {
    // Estado para el botón seleccionado
    var selectedIndex by remember { mutableStateOf(-1) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFCE200)),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        buttonItemsNavigator(
            iconRes = R.drawable.ic_home_navigator,
            text = "Inicio",
            isSelected = selectedIndex == 0
        ) {
            // Aqui puedo navegar este sera para el dasboard
            selectedIndex = 0
        }

        buttonItemsNavigator(
            iconRes = R.drawable.ic_add_opt,
            text = "Animales",
            isSelected = selectedIndex == 1
        ) {
            // Aqui puedo navegar este sera  para el registro
            selectedIndex = 1
        }

        buttonItemsNavigator(
            iconRes = R.drawable.ic_setting_opt,
            text = "Config",
            isSelected = selectedIndex == 2
        ) {
            // Aqui puedo navegar este sera para el setting
            selectedIndex = 2
        }

    }

}


@Composable
fun buttonItemsNavigator(
    iconRes: Int,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = Modifier
            .background(if (isSelected) Color(0xFFE0E0E0) else Color.Transparent) // Gris claro cuando está seleccionado
            .padding(4.dp),
    ) {
        Column(
            modifier = Modifier
                .width(60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = text,
                tint = Color.Black
            )
            Text(text = text, color = Color.Black, fontSize = 12.sp)
        }
    }
}


// Seccion de actualizaciones recientes --Blog
@Composable
fun updateSetionBoviCare() {
    Column {
        // Title review Update
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Prueba la nueva IA - Gemini 1.5 Flash",
                modifier = Modifier
                    .padding(12.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                color = Color.Black
            )
            Image(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "arrow",
                modifier = Modifier
                    .padding(12.dp)
                    .size(15.dp)
            )
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                ContainerUpdates(
                    imgRes = R.drawable.gemini_update_img,
                    title = "Modelo de IA Gemini 1.5 Flash",
                    description = "Gemini 1.5 Flash-8B es un modelo de IA rápido y económico de Google, ideal para tareas de alto volumen y baja latencia, como chat y transcripción.",
                    backgroundColor = Color.Black // Color para la imagen
                )
                ContainerUpdates(
                    imgRes = R.drawable.baked_goods_1,
                    title = "Otra actualización destacada",
                    description = "Descripción de otra actualización importante que esté disponible.",
                    backgroundColor = Color.Gray
                )
            }
        }
    }
}

@Composable
fun ContainerUpdates(
    @DrawableRes imgRes: Int, // Imagen
    title: String,
    description: String,
    backgroundColor: Color
) {
    Column(
        modifier = Modifier
            .width(355.dp)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .width(355.dp)
                .height(160.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = painterResource(imgRes),
                contentDescription = "Update",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
                    .background(backgroundColor)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 15.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        Text(
            text = description,
            color = Color.Black,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp)
        )
    }
}

@Composable
fun actionBoviCare() {
    // Estado de la lista del LazyRow
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Acciones", color = Color.Black)
        }
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            LazyRow(
                state = listState,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 35.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(5) { index ->
                    ContainerButtons(
                        imageRes = when (index) {
                            0 -> R.drawable.cow_10102195
                            1 -> R.drawable.spray_bottle_7179650
                            2 -> R.drawable.vaccine_12111387
                            3 -> R.drawable.virus_warning
                            4 -> R.drawable.prescription_14662047
                            else -> R.drawable.cow_10102195
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
                            when (index) {
                                0 -> openAnimalActivity()
                                1 -> openDesparacitacionesActivity()
                                2 -> openVacunasActivity()
                            }
                        }
                    )
                }
            }

            Image(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "Flecha hacia la derecha",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 5.dp)
                    .size(20.dp)
                    .clickable {
                        coroutineScope.launch {
                            val targetIndex = (listState.firstVisibleItemIndex + 3).coerceAtMost(4)
                            listState.animateScrollToItem(targetIndex)
                        }
                    }
            )
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

