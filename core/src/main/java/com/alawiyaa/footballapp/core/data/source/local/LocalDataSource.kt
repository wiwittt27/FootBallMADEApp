package com.alawiyaa.footballapp.core.data.source.local

import com.alawiyaa.footballapp.core.data.source.local.entity.MatchEntity
import com.alawiyaa.footballapp.core.data.source.local.entity.TeamEntity
import com.alawiyaa.footballapp.core.data.source.local.room.MatchDao
import com.alawiyaa.footballapp.core.data.source.local.room.TeamDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource constructor(private val matchDao: MatchDao, private val teamDao: TeamDao ) {

    fun getAllMatch () : Flow<List<MatchEntity>> = matchDao.getAllMatch()

    fun getAllTeams () : Flow<List<TeamEntity>> = teamDao.getAllTeams()

    suspend fun insertMatch(matchList: List<MatchEntity>) = matchDao.insertMatch(matchList)

    suspend fun insertTeam(teamList: List<TeamEntity>) = teamDao.insertTeam(teamList)

    fun getFavoriteTeam(): Flow<List<TeamEntity>> = teamDao.getListFavoriteTeam()

    fun getFavoriteMatch(): Flow<List<MatchEntity>> = matchDao.getListFavoriteMatch()

    fun setFavoriteTeam(team: TeamEntity, newState: Boolean) {
        team.isFavorite = newState
        teamDao.updateFavoriteTeam(team)
    }

    fun setFavoriteMatch(match : MatchEntity, newState: Boolean) {
        match.isFavorite = newState
        matchDao.updateFavoriteMatch(match)
    }


}