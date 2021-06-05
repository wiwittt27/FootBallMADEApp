package com.alawiyaa.footballapp.core.data.source.remote.response

import com.alawiyaa.footballapp.core.utils.DatabaseContract.EventsColumns.Companion.EVENT
import com.google.gson.annotations.SerializedName

data class MatchResponse<T> (
    @field:SerializedName(EVENT)
    val events: List<EventsItem>
)