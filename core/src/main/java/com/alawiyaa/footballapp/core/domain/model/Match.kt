package com.alawiyaa.footballapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Match (
    var idEvent: String,
    var eventName: String,
    var homeScore: String,
    var dateEvent: String,
    var awayTeam: String,
    var homeTeam: String,
    var awayScore: String,
    var league: String,
    var season: String,
    var venue: String,
    var status: String,
    var isFavorite: Boolean
    ) : Parcelable