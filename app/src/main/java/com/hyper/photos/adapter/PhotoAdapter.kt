package com.hyper.photos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hyper.photos.databinding.ListItemBinding
import com.hyper.photos.models.Photos

class PhotoAdapter(private val context: Context)
    : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    class ViewHolder(binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root){
        val image = binding.image
    }

    private var list: Photos? = null
    fun setList(list : Photos){
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun getItemCount(): Int {
        return if(list == null) 0
        else{
            list?.size!!
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model  = list?.get(position)
        Glide.with(context).load(model!!.url).into(holder.image)
    }
}