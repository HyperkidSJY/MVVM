package com.hyper.photos.api

import com.hyper.photos.models.Photos
import retrofit2.Response
import retrofit2.http.GET

interface PhotoService  {

    @GET("/photos")
    suspend fun getPhotos() : Response<Photos>
}