package com.example.database.dbManager

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


//@Database(entities = [FavoritesPhotosEntity::class], version = 1)
abstract class DatabaseManager : RoomDatabase() {

//    abstract fun favoritesPhotosDao(): PhotosDao

}
