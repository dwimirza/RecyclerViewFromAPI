package com.nanda.recyclerviewfromapi

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nanda.recyclerviewfromapi.databinding.RowItemPhotoBinding
import com.nanda.recyclerviewfromapi.response.PhotosItem

class PhotoAdapter(private val photoList : List<PhotosItem>) : RecyclerView.Adapter<PhotoAdapter.MyViewHolder>() {
    class MyViewHolder(val binding : RowItemPhotoBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
    RowItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val photo = photoList[position]
        holder.binding.apply {
            Glide.with(image.context).load(photoList[position].largeImageUrl).into(image)
        }
    }

    override fun getItemCount(): Int = photoList.size
}