package com.rahul.kotlinmvvmapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rahul.kotlinmvvmapp.model.models.ResponseClass
import com.rahul.kotlinmvvmapp.model.repository.GitRepository
import kotlinx.coroutines.Dispatchers

class GitViewModel : ViewModel() {

    private val gitRepository = GitRepository()

    fun fetchResult(): LiveData<List<ResponseClass>> {
        return liveData(Dispatchers.IO) {
            val result = gitRepository.fetchResult()
            if (result.isSuccessful) {
                result.body()?.let {
                    emit(it)
                }
            }
        }
    }
}