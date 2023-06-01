package com.hyper.photos.Viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hyper.photos.MainActivity
import com.hyper.photos.repository.PhotoRepository

class ImageViewModelFactory(private val repository: PhotoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ImageViewModel(repository) as T
    }
}