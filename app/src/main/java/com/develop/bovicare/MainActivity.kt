package com.develop.bovicare

//import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.develop.bovicare.ui.dasboard.DasboardScreen
import com.develop.bovicare.ui.home.HomeScreen
import com.develop.bovicare.ui.splash.SplashScreen
import com.develop.bovicare.ui.theme.BoviCareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val window = window
        window.statusBarColor = ContextCompat.getColor(this, R.color.yellow)

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
