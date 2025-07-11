package com.example.makeat.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

class Drawable(private val icon: Int) {
    @Composable
    fun toImageVector(): ImageVector {
        return ImageVector.vectorResource(icon)
    }
}