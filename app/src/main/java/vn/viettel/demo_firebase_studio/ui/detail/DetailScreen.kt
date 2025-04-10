package vn.viettel.demo_firebase_studio.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun DetailScreen(
    navController: NavHostController,
    itemId: Int,
    viewModel: DetailViewModel = koinViewModel { parametersOf(itemId) }
) {
    val item by viewModel.item.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Detail Screen")
        Spacer(modifier = Modifier.height(16.dp))
        if (item != null) {
            Text(text = "ID: ${item!!.id}")
            Text(text = "Name: ${item!!.name}")
            // Add more Text composables to display other properties of the item
        } else {
            Text(text = "Item not found")
        }
    }
}