package com.nsadisha.retrofitapp.api

import com.nsadisha.retrofitapp.api.model.NetworkVideoContainer
import retrofit2.Response
import retrofit2.http.GET

interface DevBytesService {
    @GET("devbytes")
    suspend fun getPlayList(): Response<NetworkVideoContainer>
}