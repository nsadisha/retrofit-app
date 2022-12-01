package com.nsadisha.retrofitapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nsadisha.retrofitapp.api.model.NetworkVideo
import com.nsadisha.retrofitapp.api.model.NetworkVideoContainer
import com.nsadisha.retrofitapp.repository.Repository
import com.nsadisha.retrofitapp.util.Utility.Companion.p
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {
    private var _videos = MutableLiveData<Response<NetworkVideoContainer>>().apply {
        emptyList<NetworkVideo>()
    }
    val videos = _videos

    var isLoadingCompleted = MutableLiveData<Boolean>().apply {
        value = false
    }

    var onErrorOccurred = MutableLiveData<Boolean>().apply {
        value = false
    }


    private fun getVideos() = viewModelScope.launch {
        try {
            val res = repository.getVideos()
            _videos.value = res
            if(res.isSuccessful){
                isLoadingCompleted.value = true
            }
        }catch (e: Exception){
            onErrorOccurred.value = true
            p(e)
        }
    }

    init {
        getVideos()
    }
}