package com.example.app

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.ui.text.input.VisualTransformation


// Navigation routes
const val LOGIN_ROUTE = "login"
const val FEATURE_LIST_ROUTE = "feature_list"

// ViewModel
class LoginViewModel : ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var isLoginSuccess by mutableStateOf(false)

    fun login() {
        viewModelScope.launch {
            // Simulate login process
            // In a real app, you would call a repository method here
            if (email == "test@example.com" && password == "password") {
                isLoginSuccess = true
            }
        }
    }
}

// Composable
@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = koinViewModel()) {
    if (viewModel.isLoginSuccess) {
        LaunchedEffect(key1 = Unit) {
            navController.navigate(FEATURE_LIST_ROUTE) {
                popUpTo(LOGIN_ROUTE) { inclusive = true }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = viewModel.email,
            onValueChange = { viewModel.email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = viewModel.password,
            onValueChange = { viewModel.password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.login() }) {
            Text("Login")
        }
    }
}