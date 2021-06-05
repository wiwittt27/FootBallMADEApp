package com.alawiyaa.footballapp.favorite.match

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.alawiyaa.footballapp.core.domain.usecase.FootBallUseCase

class FavoriteMatchViewModel(footBallUseCase: FootBallUseCase) : ViewModel() {
    val favoriteMatch = footBallUseCase.getFavoriteMatch().asLiveData()
}