package com.alawiyaa.footballapp.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.AWAY_SCORE
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.AWAY_TEAM
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.DATE_EVENT
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.EVENT_ID
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.EVENT_NAME
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.HOME_SCORE
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.HOME_TEAM
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.IS_FAVORITE
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.LEAGUE
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.SEASON
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.STATUS
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.TABLE_EVENTS
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.VENUE


@Entity(tableName = TABLE_EVENTS)
data class MatchEntity(
    @PrimaryKey
    @ColumnInfo(name = EVENT_ID)
    var idEvent: String,

    @ColumnInfo(name = EVENT_NAME)
    var eventName: String,

    @ColumnInfo(name = HOME_SCORE)
    var homeScore: String,

    @ColumnInfo(name = DATE_EVENT)
    var dateEvent: String,

    @ColumnInfo(name = AWAY_TEAM)
    var strAwayTeam: String,

    @ColumnInfo(name = HOME_TEAM)
    var homeTeam: String,

    @ColumnInfo(name = AWAY_SCORE)
    var awayScore: String,

    @ColumnInfo(name = LEAGUE)
    var league: String,

    @ColumnInfo(name = SEASON)
    var season: String,

    @ColumnInfo(name = VENUE)
    var venue: String,

    @ColumnInfo(name = STATUS)
    var status: String,

    @ColumnInfo(name = IS_FAVORITE)
    var isFavorite: Boolean = false

)