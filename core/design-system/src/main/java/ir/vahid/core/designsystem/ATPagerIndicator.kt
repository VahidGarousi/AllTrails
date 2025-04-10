package ir.vahid.core.designsystem

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
        alpha = 0.33f,
    )
    Row(
        modifier = modifier,
    ) {
        repeat(totalPages) { iteration ->
            val color = if (currentPageIndex == iteration) {
                selectedColor
            } else {
                defaultColor
            }
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(16.dp),
            )
        }
    }
}

@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun StartPagerIndicatorPreview() {
    AllTrailsTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            Surface(
                color = MaterialTheme.colorScheme.background,
            ) {
                ATPagerIndicator(
                    currentPageIndex = 0,
                    totalPages = 5,
                )
            }
        }
    }
}

@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun MiddlePagerIndicatorPreview() {
    AllTrailsTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            ATPagerIndicator(
                currentPageIndex = 2,
                totalPages = 5,
            )
        }
    }
}

@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun EndPagerIndicatorPreview() {
    AllTrailsTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            ATPagerIndicator(
                currentPageIndex = 4,
                totalPages = 5,
            )
        }
    }
}
