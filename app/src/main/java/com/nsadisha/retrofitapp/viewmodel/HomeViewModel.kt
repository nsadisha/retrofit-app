package com.nsadisha.retrofitapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nsadisha.retrofitapp.model.DevByteVideo
import com.nsadisha.retrofitapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {
    private var _videos = MutableLiveData<List<DevByteVideo>>().apply {
        emptyList<DevByteVideo>()
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
            isLoadingCompleted.value = true
        }catch (e: Exception){
            onErrorOccurred.value = true
        }
    }

    init {
        getVideos()
    }
}