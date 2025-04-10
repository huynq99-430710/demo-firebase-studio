package vn.viettel.demo_firebase_studio.ui.featurelist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import vn.viettel.demo_firebase_studio.navigation.Screen

data class FeatureItem(val id: Int, val name: String)

@Composable
fun FeatureListScreen(navController: NavController, viewModel: FeatureListViewModel = viewModel()) {
    val featureList by viewModel.featureList.collectAsState()

    LazyColumn {
        items(featureList) { item ->
            FeatureItemView(item = item) {
                navController.navigate(Screen.Detail.withArgs(item.id.toString()))
            }
        }
    }
}

@Composable
fun FeatureItemView(item: FeatureItem, onItemClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
            .padding(16.dp)
    ) {
        Text(text = item.name)
    }
}