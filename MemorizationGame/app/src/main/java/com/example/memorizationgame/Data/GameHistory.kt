package com.example.memorizationgame.Data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    primaryKeys = ["uid", "completedAt"],
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["uid"],
            childColumns = ["uid"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class GameHistory (
    val uid:Long,
    @ColumnInfo(defaultValue = "CURRENT_TIMESTAMP") val completedAt:String,
    val score:Int
)