
package __PACKAGE_NAME__.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
  var email by remember { mutableStateOf("") }
  var password by remember { mutableStateOf("") }
  var loading by remember { mutableStateOf(false) }

  Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    Column(Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
      Text("__APP_NAME__", style = MaterialTheme.typography.headlineMedium)
      Spacer(Modifier.height(24.dp))
      OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Email") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
      )
      Spacer(Modifier.height(12.dp))
      OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth()
      )
      Spacer(Modifier.height(20.dp))
      Button(
        onClick = {
          loading = true
          // TODO: validate & call auth; for template, go to dashboard
          onLoginSuccess()
        },
        enabled = !loading,
        modifier = Modifier.fillMaxWidth()
      ) { Text("Login") }
    }
  }
}