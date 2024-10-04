package com.puc.cinefy.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel() as T
        }else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}