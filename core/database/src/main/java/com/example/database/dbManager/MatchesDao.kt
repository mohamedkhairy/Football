package com.example.database.dbManager

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MatchesDao {

    @Query("SELECT * FROM favorites_matches")
    fun getAllFavorites(): List<FavoritesMatchesEntity>?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(favoritesMatches: FavoritesMatchesEntity)

    @Query("DELETE FROM favorites_matches WHERE id = :matchId")
    fun deleteById(matchId: Int): Int?

    @Query("SELECT EXISTS (SELECT 1 FROM favorites_matches WHERE id = :id)")
    fun isExist(id: Int): Boolean

}