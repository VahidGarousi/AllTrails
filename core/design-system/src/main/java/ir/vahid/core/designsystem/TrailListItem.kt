package ir.vahid.core.designsystem

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.vahid.core.design_system.R
import ir.vahid.core.designsystem.theme.AllTrailsTheme

@Composable
fun TrailListItem(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        ImageContainer()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
        ) {
            TrailInformation(
                modifier = Modifier.weight(1f),
            )
            IconButton(
                onClick = {},
            ) {
                Icon(
                    imageVector = Icons.Default.Download,
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable
private fun TrailInformation(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        TrailTitle()
        TrailGroup()
        TrailDetails()
    }
}

@Composable
private fun TrailDetails() {
    val contentColor = LocalContentColor.current.copy(
        alpha = 0.75f,
    )
    val ratingIcon = "ratingIcon"
    val string = buildAnnotatedString {
        appendInlineContent(ratingIcon, "[icon]")
        append(" 4.6 • Easy • 2.20 Miles • Est. 44m")
    }
    val inlineContent = mapOf(
        Pair(
            // This tells the [CoreText] to replace the placeholder string "[icon]" by
            // the composable given in the [InlineTextContent] object.
            ratingIcon,
            InlineTextContent(
                // Placeholder tells text layout the expected size and vertical alignment of
                // children composable.
                Placeholder(
                    width = 20.sp,
                    height = 20.sp,
                    placeholderVerticalAlign = PlaceholderVerticalAlign.Center,
                ),
            ) {
                // This Icon will fill maximum size, which is specified by the [Placeholder]
                // above. Notice the width and height in [Placeholder] are specified in TextUnit,
                // and are converted into pixel by text layout.

                Icon(Icons.Filled.Star, "", tint = contentColor, modifier = Modifier.fillMaxSize())
            },
        ),
    )

    Text(
        text = string,
        inlineContent = inlineContent,
        style = MaterialTheme.typography.labelMedium,
        color = contentColor,
    )
}

@Composable
private fun TrailGroup() {
    Text(
        text = "Lake Mohegan Loop Area",
        style = MaterialTheme.typography.labelMedium,
        color = LocalContentColor.current.copy(
            alpha = 0.75f,
        ),
    )
}

@Composable
private fun TrailTitle() {
    Text(
        text = "Lake Mohegan Loop",
        style = MaterialTheme.typography.titleLarge,
    )
}

@Composable
private fun ImageContainer() {
    Box(
        modifier = Modifier.clip(RoundedCornerShape(32.dp)),
    ) {
        TrailImage(modifier = Modifier)
        BookmarkIcon()
        ATPagerIndicator(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            totalPages = 5,
            currentPageIndex = 2,
        )
    }
}

@Composable
private fun BoxScope.BookmarkIcon() {
    IconButton(
        modifier = Modifier
            .offset(x = (-16).dp, y = 16.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.background)
            .align(Alignment.TopEnd),
        onClick = {},
    ) {
        Icon(
            imageVector = Icons.Default.BookmarkBorder,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onBackground,
        )
    }
}

/**
 * Show static image but we should convert it to pager
 */
@Composable
private fun TrailImage(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        painter = painterResource(R.drawable.trail),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
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
private fun TrailListItemPreview() {
    AllTrailsTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            TrailListItem()
        }
    }
}
