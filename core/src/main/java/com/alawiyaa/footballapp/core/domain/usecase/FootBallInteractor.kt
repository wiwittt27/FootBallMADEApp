package com.alawiyaa.footballapp.core.domain.usecase

import com.alawiyaa.footballapp.core.data.Resource
import com.alawiyaa.footballapp.core.domain.model.Match
import com.alawiyaa.footballapp.core.domain.model.Team
import com.alawiyaa.footballapp.core.domain.repository.IFootBallRepository
import kotlinx.coroutines.flow.Flow

class FootBallInteractor(private val footBallRepository: IFootBallRepository) : FootBallUseCase {



    override fun getAllMatch(): Flow<Resource<List<Match>>>  = footBallRepository.getAllMatch()

    override fun getAllTeam(): Flow<Resource<List<Team>>> = footBallRepository.getAllTeam()

    override fun getFavoriteTeam(): Flow<List<Team>> = footBallRepository.getFavoriteTeam()

    override fun getFavoriteMatch(): Flow<List<Match>> = footBallRepository.getFavoriteMatch()

    override fun setFavoriteTeam(team: Team, state: Boolean) = footBallRepository.setFavoriteTeam(team,state)

    override fun setFavoriteMatch(match: Match, state: Boolean) = footBallRepository.setFavoriteMatch(match,state)
}