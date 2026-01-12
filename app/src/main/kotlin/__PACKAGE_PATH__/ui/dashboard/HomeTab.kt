package __PACKAGE_NAME__.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeTab() {
  Column(Modifier.fillMaxSize().padding(16.dp)) {
    Text("Home", style = MaterialTheme.typography.titleLarge)
    Text("Welcome to __APP_NAME__")
  }
}
