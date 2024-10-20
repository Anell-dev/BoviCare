package com.develop.bovicare.ui.home


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

// al usar imagen de welcome
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.develop.bovicare.R


//al agregar el column
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

// al poner los vinculos
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.foundation.text.ClickableText
import android.content.Context
import androidx.compose.ui.platform.LocalContext

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFCE200)),
    ) {
        Column(
            modifier = Modifier
            .padding(PaddingValues(top = 60.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            // Imagen de la app
            Image(
                painter = painterResource(id = R.drawable.welcome),
                contentDescription = "BoviCare Logo",
                modifier = Modifier.size(300.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Bienvenido a BoviCare")
                    }
                },
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = "Tu aliado inteligente en el cuidado del ganado. Utilizamos inteligencia artificial para monitorear su salud, brindar recomendaciones personalizadas y ofrecer alertas tempranas, optimizando la gestión de su granja.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 0.dp),
                textAlign = TextAlign.Center,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    println("Botón Comenzar presionado")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .border(1.dp, Color.Black),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "Comenzar")
            }

            Spacer(modifier = Modifier.height(26.dp))

            Button(
                onClick = {
                    println("Botón Sobre la App presionado")
                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Sobre la App")
            }
        }

        val annotatedString = buildAnnotatedString {
            append("© 2024. Esta aplicación fue desarrollada por los desarrolladores ")
            pushStringAnnotation("link_bryan", "https://github.com/brayanalmengor04")
            withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)) {
                append("Bryan Almenar")
            }
            pop()
            append(" & ")
            pushStringAnnotation("link_edwin", "https://github.com/Anell-dev/")
            withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)) {
                append("Edwin González")
            }
            pop()
            append("\n\nPotenciado por ")
            pushStringAnnotation("link_ana", "https://ejemplo.com/ana")
            withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)) {
                append("Ana Patricia")
            }
            pop()
            append(". Todos los derechos reservados")
        }

        ClickableText(
            text = annotatedString,
            onClick = { offset ->
                annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.let { annotation ->
                    openLink(context, annotation.item)
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(10.dp),
            style = MaterialTheme.typography.bodySmall.copy(
                color = Color.Black,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}

private fun openLink(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
