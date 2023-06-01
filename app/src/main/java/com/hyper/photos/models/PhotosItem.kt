package com.hyper.photos.models

data class PhotosItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)