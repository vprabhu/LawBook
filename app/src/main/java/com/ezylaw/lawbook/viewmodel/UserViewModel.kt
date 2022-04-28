package com.ezylaw.lawbook.viewmodel

import androidx.lifecycle.*
import com.ezylaw.lawbook.model.User
import com.ezylaw.lawbook.room.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    val allUser: LiveData<MutableList<User>> = userRepository.getAllUserList.asLiveData()

    //Todo with no live data
    fun loginUsers(userId: Long, pwd: String): User {
        return userRepository.loginUsers(userId, pwd)
    }

    // Launching a new coroutine to insert the data in a non-blocking way
    fun insertUser(user: User) = viewModelScope.launch {
        userRepository.insertUser(user)
    }

    fun deleteUser(user: User) = viewModelScope.launch {
        userRepository.deleteUser(user)
    }

    fun updateUser(user: User) = viewModelScope.launch {
        userRepository.updateUser(user)
    }

    class UserViewModelFactory(private val userRepository: UserRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return UserViewModel(userRepository) as T
            }
            throw IllegalArgumentException("Unknown VieModel Class")
        }

    }
}
