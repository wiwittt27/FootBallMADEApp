package com.alawiyaa.footballapp.core.data.source.remote

import android.util.Log
import com.alawiyaa.footballapp.core.data.source.remote.network.ApiResponse
import com.alawiyaa.footballapp.core.data.source.remote.network.ApiService
import com.alawiyaa.footballapp.core.data.source.remote.response.EventsItem
import com.alawiyaa.footballapp.core.data.source.remote.response.TeamsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource constructor(private val apiService: ApiService) {

    suspend fun getResultMatch() : Flow<ApiResponse<List<EventsItem>>>{
        return flow {
            try {
                val response = apiService.getResultMatch()
                val dataArray = response.events
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.events))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        } .flowOn(Dispatchers.IO)
    }

    suspend fun getAllTeam() : Flow<ApiResponse<List<TeamsItem>>>{
        return flow {
            try {
                val response = apiService.getTeams()
                val dataArray = response.teams
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.teams))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

}