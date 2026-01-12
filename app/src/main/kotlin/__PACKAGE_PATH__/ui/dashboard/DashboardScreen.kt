package __PACKAGE_NAME__.ui.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
  val drawerState = rememberDrawerState(DrawerValue.Closed)
  val scope = rememberCoroutineScope()

  val tabs = listOf("Home", "Reports", "Profile")
  var selectedTab by remember { mutableStateOf(0) }

  ModalNavigationDrawer(
    drawerState = drawerState,
    drawerContent = {
      ModalDrawerSheet {
        Text("Menu", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleMedium)
        NavigationDrawerItem(label = { Text("Settings") }, selected = false, onClick = { /* TODO */ },
          modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding))
        NavigationDrawerItem(label = { Text("Help") }, selected = false, onClick = { /* TODO */ },
          modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding))
      }
    }
  ) {
    Scaffold(
      topBar = {
        TopAppBar(
          title = { Text("Dashboard") },
          navigationIcon = {
            IconButton(onClick = { scope.launch { drawerState.open() } }) {
              Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
          }
        )
      },
      floatingActionButton = {
        FloatingActionButton(onClick = { /* primary action */ }) {
          Icon(Icons.Default.Menu, contentDescription = "Action")
        }
      }
    ) { inner ->
      Column(Modifier.padding(inner)) {
        TabRow(selectedTabIndex = selectedTab) {
          tabs.forEachIndexed { index, title ->
            Tab(selected = selectedTab == index, onClick = { selectedTab = index }, text = { Text(title) })
          }
        }
        when (selectedTab) {
          0 -> HomeTab()
          1 -> ReportsTab()
          2 -> ProfileTab()
        }
      }
    }
  }
}