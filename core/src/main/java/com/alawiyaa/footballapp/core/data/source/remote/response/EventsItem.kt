package com.alawiyaa.footballapp.core.data.source.remote.response

import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.AWAY_SCORE
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.AWAY_TEAM
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.DATE_EVENT
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.EVENT_ID
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.EVENT_NAME
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.HOME_SCORE
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.HOME_TEAM
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.LEAGUE
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.SEASON
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.STATUS
import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.VENUE
import com.google.gson.annotations.SerializedName

data class EventsItem(

	@field:SerializedName(EVENT_ID)
	val idEvent: String,

	@field:SerializedName(EVENT_NAME)
	val eventName: String,


	@field:SerializedName(HOME_SCORE)
	val intHomeScore: String,

	@field:SerializedName(DATE_EVENT)
	val dateEvent: String,

	@field:SerializedName(AWAY_TEAM)
	val strAwayTeam: String,

	@field:SerializedName(HOME_TEAM)
	val strHomeTeam: String,

	@field:SerializedName(AWAY_SCORE)
	val intAwayScore: String,

	@field:SerializedName(LEAGUE)
	val league: String,

	@field:SerializedName(SEASON)
	val season: String,

	@field:SerializedName(VENUE)
	val venue: String,

	@field:SerializedName(STATUS)
	val status: String
)
