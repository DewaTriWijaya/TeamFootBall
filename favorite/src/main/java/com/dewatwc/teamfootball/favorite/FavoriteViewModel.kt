package com.dewatwc.teamfootball.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dewatwc.teamfootball.core.domain.usecase.TeamUseCase

class FavoriteViewModel(teamUseCase: TeamUseCase) : ViewModel() {
    val favoriteTeam = teamUseCase.getFavoriteTeam().asLiveData()

}