package com.example.memorizationgame.Data

import com.example.memorizationgame.App
import com.example.memorizationgame.Business.UerAccount

class UserRepository(
    private val userDao: UserDao = App.getGameDb().userDao()) {
    suspend fun createUser(newUser:UerAccount): Result<Long> {
        return try {
            val user = User(0,newUser.userName,newUser.passWord)
            val uid = userDao.createUser(user)
            Result.success(uid)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
