package com.hyper.photos.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hyper.photos.api.PhotoService
import com.hyper.photos.models.Photos

class PhotoRepository(private val photoService : PhotoService) {

    private val _photos = MutableLiveData<Photos>()

    val photos : LiveData<Photos>
    get() = _photos

    suspend fun getPhotos(){
        val result = photoService.getPhotos()
        if(result.isSuccessful && result.body() !=null){
            _photos.postValue(result.body())
        }
    }
}