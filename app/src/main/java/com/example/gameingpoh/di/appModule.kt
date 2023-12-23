package com.example.gameingpoh.di

import com.example.core.domain.usecase.GameInteractor
import com.example.core.domain.usecase.GameUseCase
import com.example.gameingpoh.detail.DetailGameViewModel
import com.example.gameingpoh.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<GameUseCase> { GameInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
//    viewModel { com.example.favorite.FavoriteViewModel(get()) }
    viewModel { DetailGameViewModel(get()) }
}