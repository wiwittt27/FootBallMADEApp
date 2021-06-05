package com.alawiyaa.footballapp.core.data.source.local.room

import androidx.room.*
import com.alawiyaa.footballapp.core.data.source.local.entity.MatchEntity
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.ID
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.IS_FAVORITE
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.TABLE_EVENTS
import kotlinx.coroutines.flow.Flow

@Dao
interface MatchDao {

    @Query("SELECT * FROM $TABLE_EVENTS ")
    fun getAllMatch() : Flow<List<MatchEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatch(match: List<MatchEntity>)

    @Query("SELECT * FROM $TABLE_EVENTS WHERE $IS_FAVORITE = $ID")
    fun getListFavoriteMatch() :  Flow<List<MatchEntity>>

    @Update
    fun updateFavoriteMatch(tourism: MatchEntity)


}