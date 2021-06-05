package com.alawiyaa.footballapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team (
        var idTeam: String,
        var teamName: String,
        var teamBadge: String,
        var formedYear: String,
        var stadiumName: String,
        var stadiumThumb: String,
        var descriptionTeam: String,
        var isFavorite: Boolean
) : Parcelable