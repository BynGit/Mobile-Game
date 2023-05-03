package com.example.games2.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Green200,
    primaryVariant = Green700,
    secondary = Green800,
    onPrimary = Green100,
    onBackground = Green500,
    error = Oranje800,
    onSurface = Green50,
    onSecondary = Green800,
    onError = Oranje500
)

private val LightColorPalette = lightColors(
    primary = Green200,
    primaryVariant = Green700,
    secondary = Oranje200,
    onPrimary = Green100,
    onBackground = Green500,
    error = Oranje800,
    onSurface = Oranje100,
    onSecondary = Green800,
    onError = Oranje500

)

@Composable
fun GamesTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}