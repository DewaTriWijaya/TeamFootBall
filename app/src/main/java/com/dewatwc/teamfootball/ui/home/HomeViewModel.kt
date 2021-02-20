package com.dewatwc.teamfootball.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dewatwc.teamfootball.core.domain.usecase.TeamUseCase

class HomeViewModel(teamUseCase: TeamUseCase) : ViewModel() {
    val team = teamUseCase.getAllTeam().asLiveData()
}