package com.puc.cinefy.movie.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbMovie")
data class Movie (
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    var title: String,
    @ColumnInfo(index = true)
    var overview: String,
    var posterPath: String,
    var voteAverage: Double,
    var releaseDate: String
) {
}