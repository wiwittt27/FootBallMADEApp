package com.alawiyaa.footballapp.favorite.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.alawiyaa.footballapp.core.domain.usecase.FootBallUseCase

class FavoriteTeamViewModel(footBallUseCase: FootBallUseCase) : ViewModel() {
    val footballTeam = footBallUseCase.getFavoriteTeam().asLiveData()
}