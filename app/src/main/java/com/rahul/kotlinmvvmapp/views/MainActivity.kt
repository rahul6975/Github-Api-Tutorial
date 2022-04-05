package com.rahul.kotlinmvvmapp.views

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.kotlinmvvmapp.databinding.ActivityMainBinding
import com.rahul.kotlinmvvmapp.model.models.ResponseClass
import com.rahul.kotlinmvvmapp.viewAdapter.ViewAdapter
import com.rahul.kotlinmvvmapp.viewModel.GitViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var gitViewModel: GitViewModel
    private lateinit var viewAdapter: ViewAdapter
    private var message = ""
    private var list = arrayListOf<ResponseClass>()
    private lateinit var mainActivityBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)
        gitViewModel = ViewModelProvider(this)[GitViewModel::class.java]
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onResume() {
        setRecyclerView()
        fetchData()
        super.onResume()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun fetchData() {
        if (isOnline(this)) {
            val result = gitViewModel.fetchResult()
            result.observe(this, {
                if (it != null) {
                    list.clear()
                    list.addAll(it)
                    viewAdapter.notifyItemChanged(0)
                    message =
                        "List of all closed pull request from repo : ${it[0].head?.repo?.name}"
                    mainActivityBinding.tvTitle.text = message
                }
            })
            mainActivityBinding.progressCircular.visibility = View.GONE
        } else {
            Toast.makeText(this, "Please check your internet", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this)
        viewAdapter = ViewAdapter(list)
        mainActivityBinding.recyclerView.apply {
            adapter = viewAdapter
            layoutManager = linearLayoutManager
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }
}