package com.nsadisha.retrofitapp.api.model

import com.nsadisha.retrofitapp.model.DevByteVideo

data class NetworkVideoContainer(
    val videos: List<NetworkVideo>
){
    fun asDomainModel(): List<DevByteVideo>{
        return videos.map {
            DevByteVideo(
                title = it.title,
                description = it.description,
                url = it.url,
                updated = it.updated,
                thumbnail = it.thumbnail
            )
        }
    }
}