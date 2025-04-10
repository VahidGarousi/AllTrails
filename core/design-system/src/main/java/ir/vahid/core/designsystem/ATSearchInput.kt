package ir.vahid.core.designsystem

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.vahid.core.designsystem.theme.AllTrailsTheme

/**
 * This is implemented as a [SearchBar] for now to
 * get as close as possible to the original design.However if decide to animate to ATrails
 * We will probably replace this with a custom component
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ATSearchInput(modifier: Modifier = Modifier) {
    SearchBar(
        modifier = modifier,
        query = "Find trails",
        onQueryChange = {},
        onSearch = {},
        active = false,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Tune,
                contentDescription = null,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = CircleShape,
                    ).padding(6.dp),
            )
        },
        onActiveChange = {},
    ) {
    }
//    TextField(
//        modifier = modifier,
//        value = "Find trails",
//        onValueChange = {},
//        shape = RoundedCornerShape(50),
//        leadingIcon = {
//            Icon(
//                imageVector = Icons.Default.Search,
//                contentDescription = null
//            )
//        },
//        trailingIcon = {
//
//        }
//    )
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
private fun ATSearchInputPreview() {
    AllTrailsTheme {
        ATSearchInput(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        )
    }
}
