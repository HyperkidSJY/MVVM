package com.hyper.photos.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyper.photos.models.Photos
import com.hyper.photos.repository.PhotoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImageViewModel(private val repository: PhotoRepository): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getPhotos()
        }
    }
    val photos : LiveData<Photos>
    get() = repository.photos
}