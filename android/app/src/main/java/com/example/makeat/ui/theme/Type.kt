package com.example.makeat.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.makeat.R


val fredokaFamily = FontFamily(
    Font(R.font.fredoka_light, FontWeight.Light),
    Font(R.font.fredoka_regular, FontWeight.Normal),
    Font(R.font.fredoka_medium, FontWeight.Medium),
    Font(R.font.fredoka_semi_bold, FontWeight.SemiBold),
    Font(R.font.fredoka_bold, FontWeight.Bold)
)


// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = fredokaFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 30.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = fredokaFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 26.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = fredokaFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = fredokaFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = fredokaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),

    bodySmall = TextStyle(
        fontFamily = fredokaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),

    labelLarge = TextStyle(
        fontFamily = fredokaFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
    ),

    labelSmall = TextStyle(
        fontFamily = fredokaFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
    ),

    )
