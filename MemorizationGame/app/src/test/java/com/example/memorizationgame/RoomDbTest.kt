package com.example.memorizationgame

import android.content.Context
import androidx.room.Room

import com.example.memorizationgame.Data.GameDatabase
import com.example.memorizationgame.Data.GameHistoryDao
import com.example.memorizationgame.Data.User
import com.example.memorizationgame.Data.UserDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.manipulation.Ordering
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import androidx.test.core.app.ApplicationProvider
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config


@RunWith(JUnit4::class)
@Config(sdk = [25])
class RoomDbTest {
    private lateinit var db:GameDatabase
    private lateinit var userDao:UserDao
    private lateinit var gameHistoryDao:GameHistoryDao

    @Before
    fun setUp(){
        val appContext = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            appContext,
            GameDatabase::class.java
        ).allowMainThreadQueries()
            .build()
        userDao = db.userDao()
        gameHistoryDao = db.gameHistoryDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun createUserTest(){
        val username1 = "mike"
        val password1 = "abc"
        val username2 = "kyle"
        val password2 = "lv"
        val id1 = userDao.createUser(User(0,username1,password1))
        print(id1)
        val id2 = userDao.createUser(User(0,username2,password2))
        print(id2)
        assert(id1>0)
        assert(id2>0)
        val users = userDao.getUsers()
        users.forEach { println("${it.uid}\t${it.username}\t${it.password}") }
    }
}