package com.nsadisha.retrofitapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nsadisha.retrofitapp.model.DevByteVideo
import com.nsadisha.retrofitapp.room.model.DatabaseVideo

@Dao
interface VideoDao {
    @Query("select * from videos")
    suspend fun getVideos(): List<DatabaseVideo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(videos: List<DatabaseVideo>)

    suspend fun getVideosAsDomainModel(): List<DevByteVideo>{
        return getVideos().map {
            DevByteVideo(
                title = it.title,
                description = it.description,
                url = it.url,
                thumbnail = it.thumbnail,
                updated = it.updated
            )
        }
    }

    suspend fun insertAllFromDomainModel(videos: List<DevByteVideo>){
        val databaseVideos = videos.map {
            DatabaseVideo(
                title = it.title,
                description = it.description,
                url = it.url,
                thumbnail = it.thumbnail,
                updated = it.updated
            )
        }

        insertAll(databaseVideos)
    }
}