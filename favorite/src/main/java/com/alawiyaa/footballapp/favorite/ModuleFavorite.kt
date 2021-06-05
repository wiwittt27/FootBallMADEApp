package com.alawiyaa.footballapp.favorite

import com.alawiyaa.footballapp.favorite.match.FavoriteMatchViewModel
import com.alawiyaa.footballapp.favorite.team.FavoriteTeamViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {

    viewModel { FavoriteMatchViewModel(get()) }
    viewModel { FavoriteTeamViewModel(get()) }
}