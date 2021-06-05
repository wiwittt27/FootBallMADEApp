package com.alawiyaa.footballapp.core.data.source.remote.network


import com.alawiyaa.footballapp.core.BuildConfig
import com.alawiyaa.footballapp.core.data.source.remote.response.EventsItem
import com.alawiyaa.footballapp.core.data.source.remote.response.MatchResponse
import com.alawiyaa.footballapp.core.data.source.remote.response.TeamResponse
import com.alawiyaa.footballapp.core.data.source.remote.response.TeamsItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/v1/json/" + BuildConfig.API_KEY + "/eventspastleague.php")
   suspend fun getResultMatch(
        @Query("id") id: String? = "4328"
    ): MatchResponse<EventsItem>

    @GET("api/v1/json/" + BuildConfig.API_KEY + "/lookup_all_teams.php")
   suspend fun getTeams(
        @Query("id") idLeague: String? = "4328"
    ): TeamResponse<TeamsItem>



}