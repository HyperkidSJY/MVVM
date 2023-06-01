package com.hyper.photos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hyper.photos.Retrofit.Helper
import com.hyper.photos.Viewmodel.ImageViewModel
import com.hyper.photos.Viewmodel.ImageViewModelFactory
import com.hyper.photos.adapter.PhotoAdapter
import com.hyper.photos.api.PhotoService
import com.hyper.photos.databinding.ActivityViewImageBinding
import com.hyper.photos.repository.PhotoRepository

class ViewImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewImageBinding
    lateinit var imageViewModel: ImageViewModel
    lateinit var photoAdapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
        setUpViewModel()

    }

    private fun setUpRecyclerView(){
        binding.rvImage.layoutManager = LinearLayoutManager(this)
        photoAdapter = PhotoAdapter(this)
        binding.rvImage.adapter = photoAdapter
    }

    private fun setUpViewModel(){
        val photoService = Helper.getInstance().create(PhotoService::class.java)
        val repository = PhotoRepository(photoService)

        imageViewModel = ViewModelProvider(this,ImageViewModelFactory(repository)).get(ImageViewModel::class.java)

        imageViewModel.photos.observe(this, Observer {
            if (it != null) {
                photoAdapter.setList(it)
                photoAdapter.notifyDataSetChanged()
            }
            else{
                Toast.makeText(this,"Error in getting Photos", Toast.LENGTH_SHORT).show()
            }
        })
    }
}