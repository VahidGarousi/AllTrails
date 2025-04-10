package ir.vahid.core.designsystem

import android.content.res.Configuration
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import ir.vahid.core.designsystem.theme.AllTrailsTheme

@Composable
fun ATBottomBar(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier,
    ) {
        ExploreTab()
        CommunityTab()
        NavigateTab()
        ProfileTab()
    }
}

@Composable
private fun RowScope.ExploreTab() {
    NavItem(
        selected = true,
        icon = Icons.Filled.Search,
        label = "Explore",
    )
}

@Composable
private fun RowScope.CommunityTab() {
    NavItem(
        selected = false,
        icon = Icons.Filled.People,
        label = "Community",
    )
}

@Composable
private fun RowScope.NavigateTab() {
    NavItem(
        selected = false,
        icon = Icons.Filled.Navigation,
        label = "Navigate",
    )
}

@Composable
private fun RowScope.ProfileTab() {
    NavigationBarItem(
        selected = false,
        onClick = {},
        icon = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null,
            )
        },
        label = {
            Text(
                text = "Profile",
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1,
            )
        },
    )
}

@Composable
private fun RowScope.NavItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
) {
    NavigationBarItem(
        selected = selected,
        onClick = {},
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = null,
            )
        },
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1,
            )
        },
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
private fun ATBottomBarPreview() {
    AllTrailsTheme {
        ATBottomBar()
    }
}
