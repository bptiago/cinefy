package com.puc.cinefy.user.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.puc.cinefy.user.model.UserSingleton
import com.puc.cinefy.user.model.User

class UserViewModel : ViewModel() {
    val usersLiveData = MutableLiveData<List<User>>()

    fun loadUsers() {
        usersLiveData.value = UserSingleton.users
    }

    fun addUser(user: User){
        UserSingleton.addUser(user)
        usersLiveData.value = UserSingleton.users
    }

    fun getUserByEmail(email: String) : User? = UserSingleton.getUser(email)

    fun refresh(){
        usersLiveData.value = UserSingleton.users
    }
}