package com.nanda.recyclerviewfromapi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nanda.recyclerviewfromapi.databinding.ActivityMainBinding
import com.nanda.recyclerviewfromapi.response.PhotoResponse
import com.nanda.recyclerviewfromapi.response.PhotosItem

class MainActivity : AppCompatActivity() {


    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var _viewmodel : PhotoViewModel? = null
    private val viewmodel get() = _viewmodel as PhotoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        _viewmodel = ViewModelProvider(this@MainActivity).get(PhotoViewModel::class.java)

        viewmodel.apply {
            getData()
            photoResponse.observe(this@MainActivity) {showData(it)}
            isLoading.observe(this@MainActivity) { showLoading(it) }
        }


    }

    private fun showData(data : List<PhotosItem>) {
        binding.apply {
            rvPhoto.layoutManager = LinearLayoutManager(this@MainActivity)
            rvPhoto.adapter = PhotoAdapter(data)
        }
    }

    private fun showLoading(isLoading : Boolean?) {
        if (isLoading == true){
            binding.rvPhoto.visibility = View.INVISIBLE
            binding.progressMain.visibility = View.VISIBLE
        } else {
            binding.rvPhoto.visibility = View.VISIBLE
            binding.progressMain.visibility = View.INVISIBLE
        }
    }

}