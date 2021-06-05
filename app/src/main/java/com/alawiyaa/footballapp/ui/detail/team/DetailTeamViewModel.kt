package com.alawiyaa.footballapp.ui.detail.team

import androidx.lifecycle.ViewModel
import com.alawiyaa.footballapp.core.domain.model.Team
import com.alawiyaa.footballapp.core.domain.usecase.FootBallUseCase

class DetailTeamViewModel(private val footBallUseCase: FootBallUseCase) : ViewModel() {
    fun setFavoriteTeam(team : Team, newStatus : Boolean) = footBallUseCase.setFavoriteTeam(team,newStatus)
}