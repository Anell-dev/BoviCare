package com.develop.bovicare

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.develop.bovicare.ui.theme.BoviCareTheme

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.develop.bovicare.ui.dasboard.DasboardScreen
import com.develop.bovicare.ui.home.HomeScreen
import com.develop.bovicare.ui.splash.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ocultar barra de estado (opcional)
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        setContent {
            val navController = rememberNavController()
            BoviCareTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "splashScreen") {
                        composable("splashScreen") {
                            SplashScreen(navController)
                        }
                        composable("homeScreen") {
                            HomeScreen(navController)
                        }

                        composable("dashboard") {
                            DasboardScreen()
                        }

                    }

                }
            }
        }
    }
}
