package com.alawiyaa.footballapp.ui.match

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.alawiyaa.footballapp.core.domain.usecase.FootBallUseCase

class ResultMatchViewModel(footBallUseCase: FootBallUseCase) : ViewModel() {

    val resultMatch = footBallUseCase.getAllMatch().asLiveData()
}