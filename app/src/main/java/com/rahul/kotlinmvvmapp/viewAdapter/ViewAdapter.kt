package com.rahul.kotlinmvvmapp.viewAdapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahul.kotlinmvvmapp.R
import com.rahul.kotlinmvvmapp.databinding.ItemLayoutBinding
import com.rahul.kotlinmvvmapp.models.ResponseClass
import java.lang.Exception
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZonedDateTime
import java.util.*
import kotlin.collections.ArrayList

class ViewAdapter(private val list: ArrayList<ResponseClass>) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val responseClass = list[position]
        holder.setData(responseClass)
    }


    override fun getItemCount(): Int {
        return list.size
    }
}

class ViewHolder(private val view: ItemLayoutBinding) : RecyclerView.ViewHolder(view.root) {
    public fun setData(responseClass: ResponseClass) {
        var createdAt = responseClass.createdAt?.split("T")
        var closedAt = responseClass.closedAt?.split("T")
        view.apply {
            tvUsername.text = responseClass.user?.login
            tvTitle.text = responseClass.title
            tvCreatedAtTime.text = createdAt?.get(0)
            tvClosedDateTime.text = closedAt?.get(0)
            Glide.with(imgUserImage).load(responseClass.user?.avatarUrl).into(imgUserImage)
        }
    }
}