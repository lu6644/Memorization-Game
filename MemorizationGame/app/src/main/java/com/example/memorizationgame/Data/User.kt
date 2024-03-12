package com.example.memorizationgame.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [
    Index(value = ["username"], unique = true)
])
data class User (
    @PrimaryKey(autoGenerate = true) val uid:Int,
    val username: String,
    val password: String
)