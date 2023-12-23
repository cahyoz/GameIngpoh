package com.example.core.domain.usecase

import com.example.core.data.GameRepository
import com.example.core.domain.model.Game
import com.example.core.domain.repository.IGameRepository


class GameInteractor(private val gameRepository: IGameRepository): GameUseCase {
    override fun getAllGame() = gameRepository.getAllGame()

    override fun getFavoriteGame() = gameRepository.getFavoriteGame()

    override fun setFavoriteGame(tourism: Game, state: Boolean) = gameRepository.setFavoriteGame(tourism, state)

}