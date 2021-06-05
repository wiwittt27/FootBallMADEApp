package com.alawiyaa.footballapp.core.domain.usecase

import com.alawiyaa.footballapp.core.data.Resource
import com.alawiyaa.footballapp.core.domain.model.Match
import com.alawiyaa.footballapp.core.domain.model.Team
import kotlinx.coroutines.flow.Flow

interface FootBallUseCase {

    fun getAllMatch() : Flow<Resource<List<Match>>>

    fun getAllTeam() : Flow<Resource<List<Team>>>

    fun getFavoriteTeam(): Flow<List<Team>>

    fun getFavoriteMatch(): Flow<List<Match>>

    fun setFavoriteTeam(team: Team, state: Boolean)

    fun setFavoriteMatch(match: Match, state: Boolean)




}
