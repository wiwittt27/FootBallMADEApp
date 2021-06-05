package com.alawiyaa.footballapp.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alawiyaa.footballapp.core.data.source.local.entity.MatchEntity
import com.alawiyaa.footballapp.core.data.source.local.entity.TeamEntity


@Database(entities = [MatchEntity::class , TeamEntity::class], version = 1 , exportSchema = false)
abstract class FootBallDatabase : RoomDatabase() {
    abstract fun matchDao() : MatchDao
    abstract fun teamDao() : TeamDao
}