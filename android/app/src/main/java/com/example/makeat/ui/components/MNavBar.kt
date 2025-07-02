package com.example.makeat.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.makeat.Plan
import com.example.makeat.Profile
import com.example.makeat.Recipes
import com.example.makeat.Stock

data class Item<T : Any>(val name: String, val route: T, val icon: ImageVector)

@Composable
fun MNavBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val navItems = listOf(
        Item("Recipes", Recipes, Icons.Rounded.Search),
        Item("Plan", Plan, Icons.Rounded.DateRange),
        Item("Stock", Stock, Icons.Rounded.Check),
        Item("Profile", Profile, Icons.Rounded.Person),
    )

    NavigationBar {
        for (item in navItems) {
            NavigationBarItem(
                icon = {
                    Icon(
                        item.icon, item.name
                    )

                },
                selected = currentDestination?.route == item.route::class.qualifiedName,
                onClick = {
                    navController.navigate(item.route)
                },
                label = { Text(item.name) }
            )
        }
    }
}