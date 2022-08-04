package com.nanda.recyclerviewfromapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nanda.recyclerviewfromapi.network.ApiConfig
import com.nanda.recyclerviewfromapi.response.PhotosItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class PhotoViewModel : ViewModel() {

    val photoResponse = MutableLiveData<List<PhotosItem>>()
    val isLoading = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Throwable>()


    fun getPhoto(
        responHandle: (List<PhotosItem>?) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        ApiConfig.getApiService().getApiKey().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandle(it.hits)
            }, {
                errorHandler(it)
            })
    }


    fun getData() {
        isLoading.value = true
        getPhoto({
            isLoading.value = false
            photoResponse.value = it
        }, {
            isLoading.value = true
            isError.value = it
        })
    }
}