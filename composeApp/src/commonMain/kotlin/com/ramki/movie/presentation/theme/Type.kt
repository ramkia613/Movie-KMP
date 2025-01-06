package com.ramki.movie.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

//val fontFamily = FontFamily(
//    Font(R.font.roboto_regular, FontWeight.Normal),
//    Font(R.font.roboto_medium, FontWeight.Medium),
//    Font(R.font.roboto_bold, FontWeight.Bold)
//)


val Typography = Typography(
    bodyLarge = TextStyle(
//        fontFamily = fontFamily,
        fontWeight = FontWeight.Companion.Normal,
        fontSize = 20.sp,
        lineHeight = 22.sp
    ),
    bodyMedium = TextStyle(
//        fontFamily = fontFamily,
        fontWeight = FontWeight.Companion.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp
    ),
    bodySmall = TextStyle(
//        fontFamily = fontFamily,
        fontWeight = FontWeight.Companion.Normal,
        fontSize = 12.sp,
        lineHeight = 18.sp
    ),
    titleLarge = TextStyle(
//        fontFamily = fontFamily,
        fontWeight = FontWeight.Companion.Bold,
        fontSize = 22.sp,
        lineHeight = 1.25.em
    ),
    titleMedium = TextStyle(
//        fontFamily = fontFamily,
        fontWeight = FontWeight.Companion.Bold,
        fontSize = 18.sp
    ),
    titleSmall = TextStyle(
//        fontFamily = fontFamily,
        fontWeight = FontWeight.Companion.SemiBold,
        fontSize = 14.sp
    ),
    labelLarge = TextStyle(
//        fontFamily = fontFamily,
        fontWeight = FontWeight.Companion.Normal,
        fontSize = 18.sp
    ),
    labelMedium = TextStyle(
//        fontFamily = fontFamily,
        fontWeight = FontWeight.Companion.Normal,
        fontSize = 14.sp,
    ),
    labelSmall = TextStyle(
//        fontFamily = fontFamily,
        fontWeight = FontWeight.Companion.Normal,
        fontSize = 10.sp
    ),
)

val LocalTypography = staticCompositionLocalOf { Typography() }
