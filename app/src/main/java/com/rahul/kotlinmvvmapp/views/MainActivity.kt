package com.rahul.kotlinmvvmapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.kotlinmvvmapp.R
import com.rahul.kotlinmvvmapp.databinding.ActivityMainBinding
import com.rahul.kotlinmvvmapp.models.ResponseClass
import com.rahul.kotlinmvvmapp.viewAdapter.ViewAdapter
import com.rahul.kotlinmvvmapp.viewModel.GitViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var gitViewModel: GitViewModel
    private lateinit var viewAdapter: ViewAdapter
    private var list = arrayListOf<ResponseClass>()
    private lateinit var mainActivityBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)
        gitViewModel = ViewModelProvider(this)[GitViewModel::class.java]
    }

    override fun onResume() {
        setRecyclerView()
        fetchData()
        super.onResume()
    }

    private fun fetchData() {
        val result = gitViewModel.fetchResult()
        result.observe(this, Observer {
            if (it != null) {
                list.addAll(it)
                viewAdapter.notifyDataSetChanged()
                mainActivityBinding.tvTitle.text =
                    "List of all closed pull request from repo : ${it[0].head?.repo?.name}"
            }
        })
        mainActivityBinding.progressCircular.visibility = View.GONE
    }

    private fun setRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this)
        viewAdapter = ViewAdapter(list)
        mainActivityBinding.recyclerView.apply {
            adapter = viewAdapter
            layoutManager = linearLayoutManager
        }
    }
}