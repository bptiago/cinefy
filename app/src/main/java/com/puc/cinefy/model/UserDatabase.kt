package com.puc.cinefy.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this){

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "users_db"
                ).allowMainThreadQueries().build()

                INSTANCE = instance
                instance
            }
        }
    }
}