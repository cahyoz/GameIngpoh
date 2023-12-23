package com.example.core.utils

import com.example.core.data.source.local.entity.GameEntity
import com.example.core.data.source.remote.response.GameResponse
import com.example.core.domain.model.Game

object DataMapper {
    fun mapResponseToEntities(input : List<GameResponse>): List<GameEntity> {
        val gameList = ArrayList<GameEntity>()
        input.map {
            val game = GameEntity(
                id = it.id,
                name = it.name,
                backgroundImage = it.backgroundImage,
                released = it.released
            )
            gameList.add(game)
        }
        return gameList
    }

    fun mapEntitiesToDomain(input: List<GameEntity>): List<Game> =
        input.map {
            Game(
                id = it.id,
                name = it.name,
                backgroundImage = it.backgroundImage,
                released = it.released,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input : Game) = GameEntity(
        id = input.id,
        name = input.name,
        backgroundImage = input.backgroundImage,
        released = input.released
    )
}