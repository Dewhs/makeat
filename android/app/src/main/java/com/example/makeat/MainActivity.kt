package com.example.makeat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
import com.example.makeat.ui.navigation.Routes
import com.example.makeat.ui.navigation.bottomNavItems
import com.example.makeat.ui.theme.MakeatTheme

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
                        if (currentDestination?.route != Routes.Login::class.qualifiedName) {
                            MNavBar(navController, bottomNavItems)
                        }
                    }) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Routes.Login,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<Routes.Login> {
                            LoginPage(onLoginSuccess = {
                                navController.navigate(
                                    Routes.Recipes
                                )
                            })
                        }
                        composable<Routes.Recipes> { RecipesPage() }
                        composable<Routes.Plan> { PlanPage() }
                        composable<Routes.Stock> { StockPage() }
                        composable<Routes.Profile> { ProfilePage() }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MakeatTheme {
        LoginPage(onLoginSuccess = {})
    }
}