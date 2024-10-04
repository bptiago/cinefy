package com.puc.cinefy.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.puc.cinefy.model.Singleton
import com.puc.cinefy.model.User

class MainViewModel : ViewModel() {
    val userLiveData = MutableLiveData<List<User>>()
    fun addUser(user: User){
        Singleton.addUser(user)
        userLiveData.value = Singleton.users
    }

    fun refresh(){
        userLiveData.value = Singleton.users
    }
}