package hossein.bakand.core.commonui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import hossein.bakand.core.commonui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BCTopAppBar(title: String) {
    Surface(
        color = MaterialTheme.colorScheme.background, shadowElevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(color = MaterialTheme.colorScheme.background),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier =Modifier.fillMaxHeight(0.75f).fillMaxWidth(),
                painter = painterResource(id = R.drawable.ic_mercedes_benz),
                contentDescription = null
            )
        }
    }
}
