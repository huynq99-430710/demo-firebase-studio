package vn.viettel.demo_firebase_studio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.koin.androidx.compose.koinViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import vn.viettel.demo_firebase_studio.ui.detail.DetailScreen
import vn.viettel.demo_firebase_studio.ui.detail.DetailViewModel
import vn.viettel.demo_firebase_studio.ui.featurelist.FeatureListScreen
import vn.viettel.demo_firebase_studio.ui.featurelist.FeatureListViewModel
import vn.viettel.demo_firebase_studio.ui.login.LoginScreen
import vn.viettel.demo_firebase_studio.ui.login.LoginViewModel
import vn.viettel.demo_firebase_studio.ui.theme.Demo_firebase_studioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appModule = module {
            single { LoginViewModel() }
            single { FeatureListViewModel() }
            single { DetailViewModel() }
        }
        startKoin {
            modules(appModule)
        }
        setContent {
            Demo_firebase_studioTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") {
                            val viewModel: LoginViewModel = koinViewModel()
                            LoginScreen(viewModel, navController)
                        }
                        composable("featureList") {
                            val viewModel: FeatureListViewModel = koinViewModel()
                            FeatureListScreen(viewModel, navController)
                        }
                        composable(
                            "detail/{itemId}",
                            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val itemId = backStackEntry.arguments?.getInt("itemId") ?: 0
                            val viewModel: DetailViewModel = koinViewModel()
                            DetailScreen(viewModel, itemId)
                        }
                    }
                }
            }
        }
    }
}