package com.ezylaw.lawbook.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ezylaw.lawbook.model.Particular
import com.ezylaw.lawbook.room.UserRepository
import kotlinx.coroutines.launch

class UserDetailViewModel(private val userRepository: UserRepository) : ViewModel() {


    // Launching a new coroutine to insert the data in a non-blocking way
    fun insertUser(particular: Particular) = viewModelScope.launch {
        userRepository.insertParticular(particular)
    }

    class PracticeViewModelFactory(private val userRepository: UserRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserDetailViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return UserDetailViewModel(userRepository) as T
            }
            throw IllegalArgumentException("Unknown VieModel Class")
        }

    }
}
