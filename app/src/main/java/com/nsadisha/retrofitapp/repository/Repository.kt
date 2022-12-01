package com.nsadisha.retrofitapp.repository

import com.nsadisha.retrofitapp.api.DevBytesService
import com.nsadisha.retrofitapp.api.model.NetworkVideoContainer
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val devBytesService: DevBytesService
)  {
    suspend fun getVideos(): Response<NetworkVideoContainer> {
        return devBytesService.getPlayList()
    }
}