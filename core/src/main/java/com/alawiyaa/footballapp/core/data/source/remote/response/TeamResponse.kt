package com.alawiyaa.footballapp.core.data.source.remote.response

import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.TEAMS
import com.google.gson.annotations.SerializedName

data class TeamResponse<T>(

	@field:SerializedName(TEAMS)
	val teams: List<TeamsItem>
)

