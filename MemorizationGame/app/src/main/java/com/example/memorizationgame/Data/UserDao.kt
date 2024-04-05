package com.example.memorizationgame.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun createUser(user: User): Long

    @Query("SELECT * FROM User WHERE username = :username " +
            "AND password = :password")
    suspend fun checkPassword(username:String, password:String): List<User>

    @Query("SELECT * FROM User")
    suspend fun getUsers(): List<User>
}