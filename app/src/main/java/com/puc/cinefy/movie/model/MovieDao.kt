package com.puc.cinefy.movie.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.puc.cinefy.user.model.User

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: Movie)

    @Query("SELECT * FROM tbMovie")
    fun getAll(): List<Movie>

    @Query("SELECT * FROM tbMovie WHERE id LIKE :data LIMIT 1")
    fun findById(data: String): Movie?
}