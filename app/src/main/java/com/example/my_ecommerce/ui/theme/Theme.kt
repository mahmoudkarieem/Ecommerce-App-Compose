package com.example.my_ecommerce.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = green,
    secondary = grey94,
    tertiary = black,
    background = whit,
    surface = grey94,
    onPrimary = whit,
    onSecondary = black,
    onTertiary = whit,
    onBackground = black,
    onSurface = black
)

private val DarkColorScheme = darkColorScheme(
    primary = green12,
    secondary = lightGrey,
    tertiary = white,
    background = darkBackground,
    surface = darkCard,
    onPrimary = black,
    onSecondary = black,
    onTertiary = black,
    onBackground = white,
    onSurface = white
)

@Composable
fun MyEcommerceTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}