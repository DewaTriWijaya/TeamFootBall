package com.dewatwc.teamfootball.core.domain.repository

import com.dewatwc.teamfootball.core.data.Resource
import com.dewatwc.teamfootball.core.domain.model.Team
import kotlinx.coroutines.flow.Flow

interface ITeamRepository {

    fun getAllTeam(): Flow<Resource<List<Team>>>

    fun getFavoriteTeam(): Flow<List<Team>>

    fun setFavoriteTeam(team: Team, state: Boolean)
}