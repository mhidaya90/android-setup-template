package __PACKAGE_NAME__

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import __PACKAGE_NAME__.ui.login.LoginScreen
import __PACKAGE_NAME__.ui.dashboard.DashboardScreen

object Routes {
  const val LOGIN = "login"
  const val DASHBOARD = "dashboard"
}

@Composable
fun AppNavGraph(nav: NavHostController) {
  NavHost(navController = nav, startDestination = Routes.LOGIN) {
    composable(Routes.LOGIN) {
      LoginScreen(onLoginSuccess = {
        nav.navigate(Routes.DASHBOARD) {
          popUpTo(Routes.LOGIN) { inclusive = true }
        }
      })
    }
    composable(Routes.DASHBOARD) {
      DashboardScreen()
    }
  }
}
