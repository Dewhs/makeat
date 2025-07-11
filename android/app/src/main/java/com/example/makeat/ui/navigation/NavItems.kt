package com.example.makeat.ui.navigation

import com.example.makeat.R
import com.example.makeat.utils.Drawable

data class NavItem(
    val label: String, val route: Routes, val icon: Drawable
)

val bottomNavItems = listOf(
    NavItem("Recipes", Routes.Recipes, Drawable(R.drawable.chef_hat)),
    NavItem("Plan", Routes.Plan, Drawable(R.drawable.calendar)),
    NavItem("Stock", Routes.Stock, Drawable(R.drawable.box)),
    NavItem("Profile", Routes.Profile, Drawable(R.drawable.user)),
)

