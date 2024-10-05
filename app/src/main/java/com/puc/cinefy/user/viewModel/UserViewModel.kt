package com.puc.cinefy.user.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.puc.cinefy.user.model.UserSingleton
import com.puc.cinefy.user.model.User

class UserViewModel : ViewModel() {
    val userLiveData = MutableLiveData<List<User>>()

    fun addUser(user: User){
        UserSingleton.addUser(user)
        userLiveData.value = UserSingleton.users
    }

    fun getUser(email: String) {
        UserSingleton.getUser(email)
    }

    fun refresh(){
        userLiveData.value = UserSingleton.users
    }
}