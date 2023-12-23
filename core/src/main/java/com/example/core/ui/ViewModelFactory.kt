//package com.example.gameingpoh.core.ui
//
//import android.content.Context
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.gameingpoh.detail.DetailGameViewModel
//import com.example.gameingpoh.favorite.FavoriteViewModel
//import com.example.gameingpoh.home.HomeViewModel
//import com.example.gameingpoh.core.di.Injection
//import com.example.gameingpoh.core.domain.usecase.GameUseCase
//
//class ViewModelFactory private constructor(private val gameUseCase: GameUseCase) :
//ViewModelProvider.NewInstanceFactory() {
//
//    companion object{
//        @Volatile
//        private var instance: ViewModelFactory? = null
//
//        fun getInstance(context: Context): ViewModelFactory =
//            instance ?: synchronized(this) {
//                instance ?: ViewModelFactory(
//                    Injection.provideTourismUseCase(context)
//                )
//            }
//    }
//
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T =
//        when {
//            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
//                HomeViewModel(gameUseCase) as T
//            }
//            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
//                FavoriteViewModel(gameUseCase) as T
//            }
//            modelClass.isAssignableFrom(DetailGameViewModel::class.java) -> {
//                DetailGameViewModel(gameUseCase) as T
//            }
//            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
//        }
//}