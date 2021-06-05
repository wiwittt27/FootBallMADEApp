package com.alawiyaa.footballapp.core.utils

import com.alawiyaa.footballapp.core.data.source.local.entity.MatchEntity
import com.alawiyaa.footballapp.core.data.source.local.entity.TeamEntity
import com.alawiyaa.footballapp.core.data.source.remote.response.EventsItem
import com.alawiyaa.footballapp.core.data.source.remote.response.TeamsItem
import com.alawiyaa.footballapp.core.domain.model.Match
import com.alawiyaa.footballapp.core.domain.model.Team

object DataMapper {

    fun mapResponsesResultMatchToEntities(input: List<EventsItem>): List<MatchEntity> {
        val matchList = ArrayList<MatchEntity>()
        input.map {
            val tourism = MatchEntity(

                    idEvent = it.idEvent,
                    eventName = it.eventName,
                    homeScore = it.intHomeScore,
                    dateEvent = it.dateEvent,
                    strAwayTeam = it.strAwayTeam,
                    homeTeam = it.strHomeTeam,
                    awayScore = it.intAwayScore,
                league = it.league,
                season = it.season,
                venue = it.venue,
                status = it.status,
                    isFavorite = false
            )
            matchList.add(tourism)
        }
        return matchList
    }

    fun mapResponsesResultTeamToEntities(input: List<TeamsItem>): List<TeamEntity> {
        val matchList = ArrayList<TeamEntity>()
        input.map {
            val tourism = it.stadiumThumb?.let { it1 ->
                TeamEntity(
                        idTeam = it.idTeam,
                        teamName = it.strAlternate,
                        teamBadge = it.strTeamBadge,
                    formedYear = it.formedYear,
                    stadiumName = it.stadiumName,
                    stadiumThumb = it1,
                    descTeam = it.descriptionTeam,
                        isFavorite = false
                )
            }
            if (tourism != null) {
                matchList.add(tourism)
            }
        }
        return matchList
    }



    fun loadResultMatch(input: List<MatchEntity>): List<Match> =
        input.map {
            Match(
                    idEvent = it.idEvent,
                eventName = it.eventName,
                    homeScore = it.homeScore,
                    dateEvent = it.dateEvent,
                    awayTeam = it.strAwayTeam,
                    homeTeam = it.homeTeam,
                    awayScore = it.awayScore,
                league = it.league,
                season = it.season,
                venue = it.venue,
                status = it.status,
                    isFavorite = it.isFavorite,

            )
        }
    fun loadResultTeam (input: List<TeamEntity>): List<Team> =
            input.map {
                Team(

                    idTeam = it.idTeam,
                    teamName = it.teamName,
                    teamBadge = it.teamBadge,
                    formedYear = it.formedYear,
                    stadiumName = it.stadiumName,
                    stadiumThumb = it.stadiumThumb,
                    descriptionTeam = it.descTeam,
                    isFavorite = false

                )
            }

    fun mapEntitiesToDomainTeam(input: List<TeamEntity>): List<Team> =
        input.map {
            Team(
                idTeam = it.idTeam,
                teamName = it.teamName,
                teamBadge = it.teamBadge,
                formedYear = it.formedYear,
                stadiumName = it.stadiumName,
                stadiumThumb = it.stadiumThumb,
                descriptionTeam = it.descTeam,
                isFavorite = it.isFavorite,
            )
        }

    fun mapEntitiesToDomainMatch(input: List<MatchEntity>): List<Match> =
        input.map {
            Match(
                idEvent = it.idEvent,
                eventName = it.eventName,
                homeScore = it.homeScore,
                dateEvent = it.dateEvent,
                awayTeam = it.strAwayTeam,
                homeTeam = it.homeTeam,
                awayScore = it.awayScore,
                league = it.league,
                season = it.season,
                venue = it.venue,
                status = it.status,
                isFavorite = it.isFavorite
            )
        }


    fun mapDomainToEntityTeam(input: Team) = TeamEntity(
        idTeam = input.idTeam,
        teamName = input.teamName,
        teamBadge = input.teamBadge,
        formedYear = input.formedYear,
        stadiumName = input.stadiumName,
        stadiumThumb = input.stadiumThumb,
        descTeam = input.descriptionTeam,
        isFavorite = input.isFavorite,
    )

    fun mapDomainToEntityMatch(input: Match) = MatchEntity(
        idEvent = input.idEvent,
        eventName = input.eventName,
        homeScore = input.homeScore,
        dateEvent = input.dateEvent,
        strAwayTeam = input.awayTeam,
        homeTeam = input.homeTeam,
        awayScore = input.awayScore,
        league = input.league,
        season = input.season,
        venue = input.venue,
        status = input.status,
        isFavorite = input.isFavorite
    )


}