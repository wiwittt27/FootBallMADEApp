package com.alawiyaa.footballapp.core.data.source.remote.response

import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.DESCRIPTION_TEAM
import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.FORMED_YEAR
import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.STADIUM_NAME
import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.STADIUM_THUMB
import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.TEAM_BADGE
import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.TEAM_ID
import com.alawiyaa.footballapp.core.utils.DatabaseContract.TeamColumns.Companion.TEAM_NAME
import com.google.gson.annotations.SerializedName

data class TeamsItem(
    @field:SerializedName(TEAM_ID)
    val idTeam: String,
    @field:SerializedName(TEAM_NAME)
    val strAlternate: String,
    @field:SerializedName(TEAM_BADGE)
    val strTeamBadge: String,

    @field:SerializedName(FORMED_YEAR)
    val formedYear: String,

    @field:SerializedName(STADIUM_NAME)
    val stadiumName: String,

    @field:SerializedName(STADIUM_THUMB)
    val stadiumThumb: String? = null,

    @field:SerializedName(DESCRIPTION_TEAM)
    val descriptionTeam: String

)