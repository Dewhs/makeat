package com.example.makeat.ui.components

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import sv.lib.squircleshape.CornerSmoothing
import sv.lib.squircleshape.SquircleShape

@Composable
fun MCheckbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = SquircleShape(radius = 25.dp, cornerSmoothing = CornerSmoothing.Full),
    size: Dp = 24.dp
) {
    val colors = MaterialTheme.colorScheme
    val animatedAlpha: Float by animateFloatAsState(
        if (checked) 1f else 0f, tween(
            durationMillis = 200,
            easing = EaseInOut
        ), label = "alpha"
    )

    Box(
        modifier = modifier
            .size(size)
            .background(
                color = colors.primary.copy(alpha = animatedAlpha),
                shape = shape
            )
            .border(
                width = 2.dp,
                color = colors.onBackground,
                shape = shape
            )
            .toggleable(
                value = checked,
                enabled = enabled,
                role = Role.Checkbox,
                onValueChange = { checkedNew -> onCheckedChange?.invoke(checkedNew) }
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "Checked",
            tint = colors.onPrimary.copy(alpha = animatedAlpha),
            modifier = Modifier.size(size * 0.8f)
        )
    }
}
