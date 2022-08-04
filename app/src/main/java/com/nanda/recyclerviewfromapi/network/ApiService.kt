package com.nanda.recyclerviewfromapi.network

import androidx.viewbinding.BuildConfig
import com.nanda.recyclerviewfromapi.BuildConfig.API_KEY
import com.nanda.recyclerviewfromapi.response.PhotoResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api")
    fun getApiKey(
        @Query("key") query:String = API_KEY
    ): Flowable<PhotoResponse>
}