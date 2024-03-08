package com.example.memorizationgame

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.memorizationgame.Data.GameDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, GameDatabase::class.java, "game").build()
    }

    companion object {
        private lateinit var db: GameDatabase
        fun getGameDb() = db
    }

}