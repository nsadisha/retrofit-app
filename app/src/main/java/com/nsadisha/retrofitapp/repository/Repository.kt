package com.nsadisha.retrofitapp.repository

import com.nsadisha.retrofitapp.api.DevBytesService
import com.nsadisha.retrofitapp.connection.InternetStatus
import com.nsadisha.retrofitapp.model.DevByteVideo
import com.nsadisha.retrofitapp.room.VideoDatabase
import com.nsadisha.retrofitapp.util.Utility.Companion.p
import javax.inject.Inject

class Repository @Inject constructor(
    private val devBytesService: DevBytesService,
    private val videoDatabase: VideoDatabase,
    private val internetStatus: InternetStatus
)  {
    suspend fun getVideos(): List<DevByteVideo> {
        try {
            val isInternetAvailable = internetStatus.isInternetAvailable()
            if(isInternetAvailable){
                p("internet")
                val result = devBytesService.getPlayList()
                if (result.isSuccessful) {
                    val videos = result.body()?.asDomainModel()!!
                    videoDatabase.videoDao.insertAllFromDomainModel(videos)
                    return videos
                }
            }
            p("no internet")
            return videoDatabase.videoDao.getVideosAsDomainModel()
        }catch (e: Exception) {
            throw Exception("Something went wrong!")
        }
    }
}