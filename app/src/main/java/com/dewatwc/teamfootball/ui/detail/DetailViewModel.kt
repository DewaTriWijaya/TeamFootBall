package com.dewatwc.teamfootball.ui.detail

import androidx.lifecycle.ViewModel
import com.dewatwc.teamfootball.core.domain.model.Team
import com.dewatwc.teamfootball.core.domain.usecase.TeamUseCase

class DetailViewModel(private val teamUseCase: TeamUseCase): ViewModel() {
    fun setFavoriteTeam(team: Team, newStatus: Boolean) = 
        teamUseCase.setFavoriteTeam(team, newStatus)
}