package com.example.memorizationgame.Data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.concurrent.TimeUnit

class GameDatabaseTest {
    private lateinit var db:GameDatabase
    private lateinit var userDao:UserDao
    private lateinit var gameHistoryDao:GameHistoryDao

    @Before
    fun setUp(){
        val appContext = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            appContext,
            GameDatabase::class.java
        ).build()
        userDao = db.userDao()
        gameHistoryDao = db.gameHistoryDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    fun populateUsers():List<Long>{
        val username1 = "mike"
        val password1 = "abc"
        val username2 = "kyle"
        val password2 = "lv"
        val id1 = userDao.createUser(User(0,username1,password1))
        println(id1)
        val id2 = userDao.createUser(User(0,username2,password2))
        println(id2)
        return listOf<Long>(id1,id2)
    }

    @Test
    fun createUserTest(){
        val list_id = populateUsers()
        assert(list_id[0] > 0)
        assert(list_id[1] > 0)
        val users = getUsers()
        assertEquals(2,users.size)
    }

    fun getUsers(): List<User>{
        val users = userDao.getUsers()
        users.forEach { println("${it.uid}\t${it.username}\t${it.password}") }
        return users
    }

    @Test
    fun addRoundScoreTest(){
        val list_id = populateUsers()
        val id1 = list_id[0]
        val id2 = list_id[1]
        gameHistoryDao.addRound(id1,100)
        TimeUnit.SECONDS.sleep(1L)
        gameHistoryDao.addRound(id1,100)
        TimeUnit.SECONDS.sleep(1L)
        gameHistoryDao.addRound(id1,80)
        TimeUnit.SECONDS.sleep(1L)
        gameHistoryDao.addRound(id1,60)
        TimeUnit.SECONDS.sleep(1L)
        gameHistoryDao.addRound(id1,100)
        TimeUnit.SECONDS.sleep(1L)
        gameHistoryDao.addRound(id2,60)
        val p1Scores = getHistories(id1)
        val p2Scores = getHistories(id2)
        assertEquals(p1Scores.size, 5)
        assertEquals(p2Scores.size, 1)
        assertEquals(p1Scores[0].score, 100)
        assertEquals(p1Scores[1].score, 60)
        assertEquals(p1Scores[2].score, 80)
    }

    fun getHistories(uid:Long): List<GameHistory>{
        val playHistory:List<GameHistory> = gameHistoryDao.getHistory(uid)
        playHistory.forEach {
            println("${it.uid}\t${it.completedAt}\t${it.score}") }
        return playHistory
    }



}