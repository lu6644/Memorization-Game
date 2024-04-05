package com.example.memorizationgame.Data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface GameHistoryDao {
    @Query("SELECT * FROM GameHistory " +
            "WHERE uid = :uid " +
            "ORDER BY completedAt DESC")
    suspend fun getHistory(uid: Long) : List<GameHistory>

    @Query("INSERT INTO GameHistory(uid,score) VALUES(:uid, :score)")
    suspend fun addRound(uid: Long, score: Int)
}