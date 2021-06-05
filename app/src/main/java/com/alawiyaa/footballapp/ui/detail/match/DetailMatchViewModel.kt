package com.alawiyaa.footballapp.ui.detail.match

import androidx.lifecycle.ViewModel
import com.alawiyaa.footballapp.core.domain.model.Match
import com.alawiyaa.footballapp.core.domain.usecase.FootBallUseCase

class DetailMatchViewModel(private val footBallUseCase: FootBallUseCase) : ViewModel() {
    fun setFavoriteMatch(match : Match, newStatus : Boolean) = footBallUseCase.setFavoriteMatch(match,newStatus)
}