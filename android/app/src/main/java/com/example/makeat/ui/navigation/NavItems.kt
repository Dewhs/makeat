package com.example.makeat.ui.navigation

import com.example.makeat.ui.theme.MIcon

class NavItem(
    val label: String, val route: Routes, val icon: MIcon
)

val bottomNavItems = listOf(
    NavItem("Recipes", Routes.Recipes, MIcon.ChefHat),
    NavItem("Plan", Routes.Plan, MIcon.Calendar),
    NavItem("Stock", Routes.Stock, MIcon.Box),
    NavItem("Profile", Routes.Profile, MIcon.User),
)

