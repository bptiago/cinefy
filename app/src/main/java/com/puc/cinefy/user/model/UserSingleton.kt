package com.puc.cinefy.user.model

import android.content.Context

object UserSingleton {
    lateinit var users: List<User>
    lateinit var dao: UserDao

    fun init(context: Context) {
        UserDatabase.getInstance(context)?.apply {
            dao = userDao()
            users = dao.getAll()
        }
    }

    fun addUser(user: User) {
        dao.insert(user)
        users = dao.getAll()
    }

    fun getUser(email: String): User? = dao.findByEmail(email)
}