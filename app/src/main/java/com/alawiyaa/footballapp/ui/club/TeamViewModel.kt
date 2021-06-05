package com.alawiyaa.footballapp.ui.club

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.alawiyaa.footballapp.core.domain.usecase.FootBallUseCase

class TeamViewModel(footBallUseCase: FootBallUseCase) : ViewModel() {


    val team = footBallUseCase.getAllTeam().asLiveData()

}