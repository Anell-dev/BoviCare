package com.develop.bovicare.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.develop.bovicare.ui.theme.BoviCareTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFFFCE200)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("BoviCare")
                }
            },
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFFFFFFFF),
            fontSize = 50.sp

        )
    }

    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("homeScreen") {
            popUpTo("splashScreen") { inclusive = true }
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    BoviCareTheme {
        SplashScreen(navController = rememberNavController())
    }
}
