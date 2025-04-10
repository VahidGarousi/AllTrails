@file:Suppress("LongParameterList")

package ir.vahid.core.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ir.vahid.core.designsystem.theme.AllTrailsTheme

@Composable
fun ATPagerIndicator(
    modifier: Modifier = Modifier,
    currentPageIndex: Int,
    totalPages: Int,
) {
    val selectedColor = Color.White
    val defaultColor = selectedColor.copy(
        alpha = 0.50f,
    )
    val defaultSize = 12.dp
    val minSize = 8.dp
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier,
    ) {
        StartIndicator(
            currentPageIndex = currentPageIndex,
            selectedColor = selectedColor,
            defaultColor = defaultColor,
            defaultSize = defaultSize,
            minSize = minSize,
        )
        MidIndicator(
            totalPages = totalPages,
            currentPageIndex = currentPageIndex,
            selectedColor = selectedColor,
            defaultColor = defaultColor,
            defaultSize = defaultSize,
        )
        EndIndicator(
            currentPageIndex = currentPageIndex,
            totalPages = totalPages,
            selectedColor = selectedColor,
            defaultColor = defaultColor,
            defaultSize = defaultSize,
            minSize = minSize,
        )
    }
}

@Composable
private fun EndIndicator(
    currentPageIndex: Int,
    totalPages: Int,
    selectedColor: Color,
    defaultColor: Color,
    defaultSize: Dp,
    minSize: Dp,
) {
    val endIndicatorColor = when {
        currentPageIndex == totalPages - 1 -> selectedColor
        else -> defaultColor
    }
    val endIndicatorSize = when {
        currentPageIndex >= totalPages - 2 -> defaultSize
        else -> minSize
    }
    IndicatorDot(
        color = endIndicatorColor,
        size = endIndicatorSize,
    )
}

@Composable
private fun StartIndicator(
    currentPageIndex: Int,
    selectedColor: Color,
    defaultColor: Color,
    defaultSize: Dp,
    minSize: Dp,
) {
    val startIndicatorColor = when {
        currentPageIndex == 0 -> selectedColor
        else -> defaultColor
    }
    val startIndicatorSize = when {
        currentPageIndex <= 1 -> defaultSize
        else -> minSize
    }
    IndicatorDot(
        color = startIndicatorColor,
        size = startIndicatorSize,
    )
}

@Composable
private fun MidIndicator(
    currentPageIndex: Int,
    totalPages: Int,
    selectedColor: Color,
    defaultColor: Color,
    defaultSize: Dp,
) {
    val midIndicatorColor = when {
        currentPageIndex > 0 && currentPageIndex < totalPages - 1 -> selectedColor
        else -> defaultColor
    }
    IndicatorDot(
        color = midIndicatorColor,
        size = defaultSize,
    )
}

@Composable
private fun IndicatorDot(
    modifier: Modifier = Modifier,
    color: Color,
    size: Dp,
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color)
            .size(size),
    )
}

@Preview
@Composable
private fun StartPagerIndicatorPreview() {
    AllTrailsTheme {
        Surface(
            color = Color.Black,
        ) {
            ATPagerIndicator(
                currentPageIndex = 0,
                totalPages = 5,
            )
        }
    }
}

@Preview
@Composable
private fun MiddlePagerIndicatorPreview() {
    AllTrailsTheme {
        Surface(
            color = Color.Black,
        ) {
            ATPagerIndicator(
                currentPageIndex = 2,
                totalPages = 5,
            )
        }
    }
}

@Preview
@Composable
private fun EndPagerIndicatorPreview() {
    AllTrailsTheme {
        Surface(
            color = Color.Black,
        ) {
            ATPagerIndicator(
                currentPageIndex = 4,
                totalPages = 5,
            )
        }
    }
}

@Preview
@Composable
private fun SmallCountPagerIndicatorPreview() {
    AllTrailsTheme {
        Surface(
            color = Color.Black,
        ) {
            ATPagerIndicator(
                currentPageIndex = 0,
                totalPages = 2,
            )
        }
    }
}
