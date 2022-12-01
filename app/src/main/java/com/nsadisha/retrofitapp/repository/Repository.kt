package com.nsadisha.retrofitapp.repository

import com.nsadisha.retrofitapp.api.DevBytesService
import com.nsadisha.retrofitapp.model.DevByteVideo
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val devBytesService: DevBytesService
)  {
    suspend fun getVideos(): List<DevByteVideo> {
        val result = devBytesService.getPlayList()
        if (result.isSuccessful){
            return result.body()?.asDomainModel()!!
        }
        return emptyList()
    }
}