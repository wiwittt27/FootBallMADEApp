package com.alawiyaa.footballapp.di

import com.alawiyaa.footballapp.core.domain.usecase.FootBallInteractor
import com.alawiyaa.footballapp.core.domain.usecase.FootBallUseCase
import com.alawiyaa.footballapp.ui.club.TeamViewModel
import com.alawiyaa.footballapp.ui.detail.match.DetailMatchViewModel
import com.alawiyaa.footballapp.ui.detail.team.DetailTeamViewModel

import com.alawiyaa.footballapp.ui.match.ResultMatchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<FootBallUseCase> { FootBallInteractor(get()) }
}

val viewModelModule = module {
    viewModel { ResultMatchViewModel(get()) }
    viewModel { TeamViewModel(get()) }
    viewModel { DetailMatchViewModel(get()) }
    viewModel { DetailTeamViewModel(get()) }
}