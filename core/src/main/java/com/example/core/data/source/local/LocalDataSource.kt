package com.example.core.data.source.local

import com.example.core.data.source.local.entity.GameEntity
import com.example.core.data.source.local.room.GameDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val gameDao: GameDao) {

    companion object {
        private var instance: com.example.core.data.source.local.LocalDataSource? = null

//        fun getInstance(gameDao: GameDao): LocalDataSource =
//            instance ?: synchronized(this) {
//                instance ?: LocalDataSource(gameDao)
//            }
    }

    fun getAllGame(): Flow<List<GameEntity>> = gameDao.getAllGame()

    fun getFavoriteGame(): Flow<List<GameEntity>> = gameDao.getFavoriteGame()

    suspend fun insertGame(tourismList: List<GameEntity>) = gameDao.insertGame(tourismList)

    fun setFavoriteGame(tourism: GameEntity, newState: Boolean) {
        tourism.isFavorite = newState
        gameDao.updateFavoriteGame(tourism)
    }
}