package com.example.makeat.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import border
import com.example.makeat.Plan
import com.example.makeat.Profile
import com.example.makeat.R
import com.example.makeat.Recipes
import com.example.makeat.Stock

data class Item<T : Any>(val name: String, val route: T, val icon: ImageVector)

@Composable
fun MNavBar(navController: NavHostController, modifier: Modifier = Modifier) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val navItems = listOf(
        Item("Recipes", Recipes, ImageVector.vectorResource(R.drawable.chef_hat)),
        Item("Plan", Plan, ImageVector.vectorResource(R.drawable.calendar)),
        Item("Stock", Stock, ImageVector.vectorResource(R.drawable.box)),
        Item("Profile", Profile, ImageVector.vectorResource(R.drawable.user)),
    )

    NavigationBar(
        modifier = modifier.border(
            side = BorderSide.TOP,
            width = 2.dp,
            color = MaterialTheme.colorScheme.outline
        ),
        containerColor = MaterialTheme.colorScheme.surface,
    ) {
        for (item in navItems) {
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.background,
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground,
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground
                ),
                icon = {
                    Icon(
                        item.icon, item.name
                    )

                },
                selected = currentDestination?.route == item.route::class.qualifiedName,
                onClick = {
                    navController.navigate(item.route)
                },
                label = { Text(item.name, style = MaterialTheme.typography.labelSmall) },
            )
        }
    }
}