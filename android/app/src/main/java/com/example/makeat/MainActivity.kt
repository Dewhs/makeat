package com.example.makeat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.makeat.ui.LoginPage
import com.example.makeat.ui.RecipesPage
import com.example.makeat.ui.theme.MakeatTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MakeatTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Login) {
                    composable<Login> { LoginPage(onLoginSuccess = {navController.navigate(Recipes)}) }
                    composable<Recipes> { RecipesPage() }
                }
            }
        }
    }
}

@Serializable
object Login

@Serializable
object Recipes

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MakeatTheme {
//        LoginPage()
//    }
//}