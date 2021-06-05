package com.alawiyaa.footballapp.core.data.source.local.room

import androidx.room.*
import com.alawiyaa.footballapp.core.data.source.local.entity.TeamEntity
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.IS_FAVORITE
import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.TABLE_TEAMS
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {
    @Query("SELECT * FROM $TABLE_TEAMS ")
    fun getAllTeams() : Flow<List<TeamEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(team: List<TeamEntity>)

    @Query("SELECT * FROM $TABLE_TEAMS WHERE $IS_FAVORITE = 1")
    fun getListFavoriteTeam() :  Flow<List<TeamEntity>>

    @Update
    fun updateFavoriteTeam(tourism: TeamEntity)


}