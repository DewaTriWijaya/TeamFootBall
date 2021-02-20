package com.dewatwc.teamfootball.di

import com.dewatwc.teamfootball.core.domain.usecase.TeamInteractor
import com.dewatwc.teamfootball.core.domain.usecase.TeamUseCase
import com.dewatwc.teamfootball.ui.detail.DetailViewModel
import com.dewatwc.teamfootball.ui.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TeamUseCase> { TeamInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}