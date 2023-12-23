package com.example.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.GameUseCase


class FavoriteViewModel(gameuseCase: GameUseCase) : ViewModel() {
    val favoriteGame = gameuseCase.getFavoriteGame().asLiveData()
}
