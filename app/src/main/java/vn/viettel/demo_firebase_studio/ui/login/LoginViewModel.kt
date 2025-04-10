package vn.viettel.demo_firebase_studio.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class LoginViewModel : ViewModel(), KoinComponent {

    fun login(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            // Simulate login process
            if (email == "test@example.com" && password == "password") {
                onSuccess()
            } else {
                onError("Invalid email or password")
            }
        }
    }
}