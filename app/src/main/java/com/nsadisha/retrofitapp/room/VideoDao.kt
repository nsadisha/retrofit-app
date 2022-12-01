package com.nsadisha.retrofitapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nsadisha.retrofitapp.room.model.DatabaseVideo

@Dao
interface VideoDao {
    @Query("select * from videos")
    fun getVideos(): List<DatabaseVideo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(videos: List<DatabaseVideo>)
}