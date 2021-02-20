package com.dewatwc.teamfootball.core.utils

import com.dewatwc.teamfootball.core.data.local.entity.TeamEntity
import com.dewatwc.teamfootball.core.data.remote.response.TeamResponse
import com.dewatwc.teamfootball.core.domain.model.Team

object DataMapper {

    fun mapResponsesToEntities(input: List<TeamResponse>): List<TeamEntity> {
        val teamList = ArrayList<TeamEntity>()
        input.map {
            val team = TeamEntity(
                idTeam = it.idTeam,
                name = it.name,
                stadium = it.stadium,
                img = it.img,
                description = it.description,
                isFavorite = false
            )
            teamList.add(team)
        }
        return teamList
    }

    fun mapEntitiesToDomain(input: List<TeamEntity>): List<Team> =
        input.map {
            Team(
                idTeam = it.idTeam,
                name = it.name,
                stadium = it.stadium,
                img = it.img,
                description = it.description,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Team) = TeamEntity(
        idTeam = input.idTeam,
        name = input.name,
        stadium = input.stadium,
        img = input.img,
        description = input.description,
        isFavorite = input.isFavorite
    )
}