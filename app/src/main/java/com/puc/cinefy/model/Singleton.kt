package com.puc.cinefy.model

import android.content.Context

object Singleton {
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

    fun getUser(user: User): User? = dao.findByEmail(user.email)
}