package com.example.makeat.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import border
import com.example.makeat.ui.navigation.NavItem

@Composable
fun MNavBar(
    navController: NavHostController, navItems: List<NavItem>, modifier: Modifier = Modifier
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = modifier.border(
            side = BorderSide.TOP, width = 2.dp, color = MaterialTheme.colorScheme.outline
        ),
        containerColor = MaterialTheme.colorScheme.surface,
    ) {
        val navBarItemColors = NavigationBarItemDefaults.colors(
            indicatorColor = MaterialTheme.colorScheme.background,
            selectedIconColor = MaterialTheme.colorScheme.primary,
            selectedTextColor = MaterialTheme.colorScheme.primary,
            unselectedIconColor = MaterialTheme.colorScheme.onBackground,
            unselectedTextColor = MaterialTheme.colorScheme.onBackground
        )

        for (item in navItems) {
            NavigationBarItem(
                colors = navBarItemColors,
                icon = {
                    Icon(
                        item.icon.toImageVector(), item.label
                    )
                },
                selected = currentDestination?.route == item.route::class.qualifiedName,
                onClick = {
                    navController.navigate(item.route)
                },
                label = { Text(item.label, style = MaterialTheme.typography.labelSmall) },
            )
        }
    }
}