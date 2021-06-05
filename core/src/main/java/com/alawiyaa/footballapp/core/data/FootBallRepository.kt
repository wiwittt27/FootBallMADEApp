package com.alawiyaa.footballapp.core.data

import com.alawiyaa.footballapp.core.data.source.local.LocalDataSource
import com.alawiyaa.footballapp.core.data.source.remote.RemoteDataSource
import com.alawiyaa.footballapp.core.data.source.remote.network.ApiResponse
import com.alawiyaa.footballapp.core.data.source.remote.response.EventsItem
import com.alawiyaa.footballapp.core.data.source.remote.response.TeamsItem
import com.alawiyaa.footballapp.core.domain.model.Match
import com.alawiyaa.footballapp.core.domain.model.Team
import com.alawiyaa.footballapp.core.domain.repository.IFootBallRepository
import com.alawiyaa.footballapp.core.utils.DataMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class FootBallRepository constructor(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
) : IFootBallRepository{
    override fun getAllMatch(): Flow<Resource<List<Match>>>  =
            object  : NetworkBoundResource<List<Match>, List<EventsItem>>(){
                override fun loadFromDB(): Flow<List<Match>> {
                   return localDataSource.getAllMatch().map {
                       DataMapper.loadResultMatch(it)
                   }
                }

                override fun shouldFetch(data: List<Match>?): Boolean {
                   return data == null || data.isEmpty()

                }

                override suspend fun createCall(): Flow<ApiResponse<List<EventsItem>>> {
                   return  remoteDataSource.getResultMatch()
                }

                override suspend fun saveCallResult(data: List<EventsItem>) {
                   val matchList = DataMapper.mapResponsesResultMatchToEntities(data)
                    localDataSource.insertMatch(matchList)
                }
            }.asFlow()


    override fun getAllTeam(): Flow<Resource<List<Team>>> =
            object  :NetworkBoundResource<List<Team>, List<TeamsItem>>(){
                override fun loadFromDB(): Flow<List<Team>> {
                    return localDataSource.getAllTeams().map {
                        DataMapper.loadResultTeam(it)
                    }
                }

                override fun shouldFetch(data: List<Team>?): Boolean {
                    //menentukan kapan bisa mengambil data dari remote
                    return data == null || data.isEmpty()

                }

                override suspend fun createCall(): Flow<ApiResponse<List<TeamsItem>>> {
                    //Ketika data pada local kosong, maka aplikasi akan mengambil data dari remote
                    return  remoteDataSource.getAllTeam()
                }

                override suspend fun saveCallResult(data: List<TeamsItem>) {
                    val teamList = DataMapper.mapResponsesResultTeamToEntities(data)
                    localDataSource.insertTeam(teamList)
                }
            }.asFlow()

    override fun getFavoriteTeam(): Flow<List<Team>> {
      return localDataSource.getFavoriteTeam().map { DataMapper.mapEntitiesToDomainTeam(it) }
    }

    override fun getFavoriteMatch(): Flow<List<Match>> {
       return localDataSource.getFavoriteMatch().map { DataMapper.mapEntitiesToDomainMatch(it) }
    }

    override fun setFavoriteTeam(team: Team, state: Boolean) {
        CoroutineScope(IO).launch {
            val teamEntity = DataMapper.mapDomainToEntityTeam(team)
            localDataSource.setFavoriteTeam(teamEntity,state)
        }

    }

    override fun setFavoriteMatch(match: Match, state: Boolean) {
        CoroutineScope(IO).launch {
            val matchEntity = DataMapper.mapDomainToEntityMatch(match)
            localDataSource.setFavoriteMatch(matchEntity,state)
        }
    }

}