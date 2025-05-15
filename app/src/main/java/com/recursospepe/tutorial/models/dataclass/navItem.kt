package com.recursospepe.tutorial.models.dataclass

import androidx.compose.ui.graphics.vector.ImageVector

data class navItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)
