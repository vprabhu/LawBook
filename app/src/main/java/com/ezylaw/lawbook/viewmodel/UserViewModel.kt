package com.ezylaw.lawbook.viewmodel

import androidx.lifecycle.*
import com.ezylaw.lawbook.model.User
import com.ezylaw.lawbook.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    val allUser: LiveData<MutableList<User>> = userRepository.allUsers.asLiveData()

    // Launching a new coroutine to insert the data in a non-blocking way
    fun insert(user: User) = viewModelScope.launch {
        userRepository.insert(user)
    }

    fun delete(user: User) = viewModelScope.launch {
        userRepository.delete(user)
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
