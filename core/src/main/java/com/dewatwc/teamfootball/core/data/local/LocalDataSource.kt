package com.dewatwc.teamfootball.core.data.local

import com.dewatwc.teamfootball.core.data.local.entity.TeamEntity
import com.dewatwc.teamfootball.core.data.local.room.TeamDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val teamDao: TeamDao) {

    fun getAllTeam(): Flow<List<TeamEntity>> = teamDao.getAllTeam()

    fun getFavoriteTeam(): Flow<List<TeamEntity>> = teamDao.getFavoriteTeam()

    suspend fun insertTeam(teamList: List<TeamEntity>) = teamDao.insertTeam(teamList)

    fun setFavoriteTeam(teamEntity: TeamEntity, newState: Boolean){
        teamEntity.isFavorite = newState
        teamDao.updateFavoriteTeam(teamEntity)
    }
}