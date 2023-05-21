package com.example.database.dbManager

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.home.data.local.MatchesDao
import com.example.home.data.local.entity.FavoritesMatchesEntity


@Database(entities = [FavoritesMatchesEntity::class], version = 1)
abstract class DatabaseManager : RoomDatabase() {

    abstract fun favoritesPhotosDao(): MatchesDao

}
