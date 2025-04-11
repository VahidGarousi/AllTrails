package ir.vahid.core.designsystem

import android.content.res.Configuration
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ir.vahid.core.designsystem.theme.AllTrailsTheme

@Composable
fun ScrollingText(
    modifier: Modifier = Modifier,
    text: String,
) {
    AnimatedContent(
        modifier = modifier,
        transitionSpec = {
            textChangeAnimation()
        },
        targetState = text,
    ) {
        Text(
            text = it,
        )
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
private fun ScrollingTextPreview() {
    AllTrailsTheme {
        ScrollingText(
            text = "",
        )
    }
}

private fun textChangeAnimation(textDurationMillis: Int = 500): ContentTransform {
    val enterTransition = slideInVertically(
        animationSpec = tween(durationMillis = textDurationMillis),
    ) { height -> height } + fadeIn(
        animationSpec = tween(durationMillis = textDurationMillis),
    )
    val exitTransition = slideOutVertically(
        animationSpec = tween(durationMillis = textDurationMillis),
    ) { height -> -height } + fadeOut(
        animationSpec = tween(durationMillis = textDurationMillis),
    )
    return enterTransition.togetherWith(exitTransition)
}
