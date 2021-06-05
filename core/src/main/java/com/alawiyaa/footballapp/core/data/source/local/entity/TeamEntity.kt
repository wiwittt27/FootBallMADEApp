package com.alawiyaa.footballapp.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.IS_FAVORITE
import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.DESCRIPTION_TEAM
import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.FORMED_YEAR
import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.STADIUM_NAME
import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.STADIUM_THUMB
import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.TABLE_TEAMS
import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.TEAM_BADGE
import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.TEAM_ID
import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.TEAM_NAME
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = TABLE_TEAMS)
data class TeamEntity (
    @PrimaryKey
    @ColumnInfo(name = TEAM_ID)
    var idTeam: String,

    @ColumnInfo(name = TEAM_NAME)
    var teamName: String,

    @ColumnInfo(name = TEAM_BADGE)
    var teamBadge: String,

    @ColumnInfo(name = FORMED_YEAR)
    var formedYear: String,

    @ColumnInfo(name = STADIUM_NAME)
    var stadiumName: String,

    @ColumnInfo(name = STADIUM_THUMB)
    var stadiumThumb: String,

    @ColumnInfo(name = DESCRIPTION_TEAM)
    var descTeam: String,


    @ColumnInfo(name = IS_FAVORITE)
    var isFavorite: Boolean = false



) : Parcelable