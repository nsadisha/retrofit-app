package com.nsadisha.retrofitapp.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "videos")
data class DatabaseVideo(
    @PrimaryKey
    val url: String,
    val title: String,
    val description: String,
    val updated: String,
    val thumbnail: String
)