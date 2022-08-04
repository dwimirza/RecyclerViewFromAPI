package com.nanda.recyclerviewfromapi.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoResponse(
    @field:SerializedName("hits")
    val hits: List<PhotosItem>? = null
):Parcelable

@Parcelize
data class PhotosItem(

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("pageURL")
    val pageUrl: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("tags")
    val tags: String? = null,

    @field:SerializedName("previewURL")
    val previewUrl: String? = null,

    @field:SerializedName("webformatURL")
    val webFormatUrl: String? = null,

    @field:SerializedName("largeImageURL")
    val largeImageUrl: String? = null,

    @field:SerializedName("views")
    val views: String? = null,

    @field:SerializedName("downloads")
    val downloads: String? = null,

    @field:SerializedName("collections")
    val collections: String? = null,

    @field:SerializedName("likes")
    val likes: String? = null,

    @field:SerializedName("user_id")
    val userId: String? = null,

    @field:SerializedName("user")
    val user: String? = null,

    @field:SerializedName("userImageURL")
    val userImageUrl: String? = null,



):Parcelable
