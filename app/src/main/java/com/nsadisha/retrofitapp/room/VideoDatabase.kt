package com.nsadisha.retrofitapp.room

import androidx.room.Database
import com.nsadisha.retrofitapp.room.model.DatabaseVideo

@Database(entities = [DatabaseVideo::class], version = 1)
abstract class VideoDatabase {
    abstract val videoDao: VideoDao
}