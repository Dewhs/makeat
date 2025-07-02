package com.example.makeat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.makeat.ui.LoginPage
import com.example.makeat.ui.PlanPage
import com.example.makeat.ui.ProfilePage
import com.example.makeat.ui.RecipesPage
import com.example.makeat.ui.StockPage
import com.example.makeat.ui.components.MNavBar
import com.example.makeat.ui.theme.MakeatTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MakeatTheme {

                val navController = rememberNavController()

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                Scaffold(
                    bottomBar = {
                        if (currentDestination?.route != Login::class.qualifiedName) {
                            MNavBar(navController)
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Login,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<Login> {
                            LoginPage(onLoginSuccess = {
                                navController.navigate(
                                    Recipes
                                )
                            })
                        }
                        composable<Recipes> { RecipesPage() }
                        composable<Plan> { PlanPage() }
                        composable<Stock> { StockPage() }
                        composable<Profile> { ProfilePage() }
                    }
                }
            }
        }
    }
}

@Serializable
object Login

@Serializable
object Recipes

@Serializable
object Plan

@Serializable
object Stock

@Serializable
object Profile

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MakeatTheme {
//        LoginPage()
//    }
//}