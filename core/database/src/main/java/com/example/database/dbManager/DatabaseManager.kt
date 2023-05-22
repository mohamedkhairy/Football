package com.example.database.dbManager

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [FavoritesMatchesEntity::class], version = 1)
abstract class DatabaseManager : RoomDatabase() {

    abstract fun favoritesMatchesDao(): MatchesDao

}
