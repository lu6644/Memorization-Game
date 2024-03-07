package com.example.memorizationgame.Data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class, GameHistory::class], version = 1)
abstract class GameDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun gameHistoryDao(): GameHistoryDao
}