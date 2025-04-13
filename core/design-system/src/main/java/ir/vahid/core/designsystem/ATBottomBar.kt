package ir.vahid.core.designsystem

import android.content.res.Configuration
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
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
        SavedTab()
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
private fun RowScope.SavedTab() {
    NavItem(
        selected = false,
        icon = Icons.Filled.Bookmark,
        label = "Saved",
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
    val selectedColor = MaterialTheme.colorScheme.onSurface
    val unselectedColor = MaterialTheme.colorScheme.onSurface.copy(
        alpha = 0.50f,
    )
    val colorsWithoutIndicator = NavigationBarItemDefaults.colors(
        indicatorColor = Color.Transparent,
        selectedIconColor = selectedColor,
        selectedTextColor = selectedColor,
        unselectedIconColor = unselectedColor,
        unselectedTextColor = unselectedColor,
    )
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
                fontWeight = FontWeight.Bold.takeIf { selected },
            )
        },
        colors = colorsWithoutIndicator,
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
