package com.puc.cinefy.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("SELECT * FROM tbUser")
    fun getAll(): List<User>

    @Query("SELECT * FROM tbUser WHERE email LIKE :data LIMIT 1")
    fun findByEmail(data: String): User?
}