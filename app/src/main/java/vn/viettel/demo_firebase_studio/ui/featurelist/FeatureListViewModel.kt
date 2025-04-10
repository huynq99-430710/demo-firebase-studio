package vn.viettel.demo_firebase_studio.ui.featurelist

import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinComponent

data class Feature(val id: Int, val name: String)

class FeatureListViewModel : ViewModel(), KoinComponent {
    val featureList = listOf(
        Feature(1, "Feature 1"),
        Feature(2, "Feature 2"),
        Feature(3, "Feature 3"),
        Feature(4, "Feature 4"),
        Feature(5, "Feature 5")
    )
}