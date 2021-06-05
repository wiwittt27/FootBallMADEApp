package com.alawiyaa.footballapp.core.utils

import android.provider.BaseColumns

object DatabaseContract {
    internal class EventsColumns : BaseColumns {
        companion object {
            const val TABLE_EVENTS = "tb_events"
            const val ID = 1
            const val EVENT = "events"
            const val EVENT_ID = "idEvent"
            const val EVENT_NAME = "strEvent"
            const val HOME_SCORE = "intHomeScore"
            const val DATE_EVENT = "dateEvent"
            const val AWAY_TEAM = "strAwayTeam"
            const val HOME_TEAM = "strHomeTeam"
            const val AWAY_SCORE = "intAwayScore"
            const val LEAGUE = "strLeague"
            const val SEASON = "strSeason"
            const val VENUE = "strVenue"
            const val STATUS = "strStatus"
            const val IS_FAVORITE = "isFavorite"
        }
    }
    internal class TeamColumns : BaseColumns{
        companion object{
            const val TABLE_TEAMS = "tb_teams"
            const val TEAMS = "teams"
            const val TEAM_ID = "idTeam"
            const val TEAM_NAME = "strAlternate"
            const val TEAM_BADGE = "strTeamBadge"
            const val FORMED_YEAR = "intFormedYear"
            const val STADIUM_NAME = "strStadium"
            const val STADIUM_THUMB = "strStadiumThumb"
            const val DESCRIPTION_TEAM = "strDescriptionEN"
        }
    }
}