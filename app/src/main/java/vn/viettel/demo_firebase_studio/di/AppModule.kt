package vn.viettel.demo_firebase_studio

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import vn.viettel.demo_firebase_studio.ui.detail.DetailViewModel
import vn.viettel.demo_firebase_studio.ui.featurelist.FeatureListViewModel
import vn.viettel.demo_firebase_studio.ui.login.LoginViewModel

val appModule = module {
    viewModel { LoginViewModel() }
    viewModel { FeatureListViewModel() }
    viewModel { DetailViewModel() }
}