package com.ezylaw.lawbook.viewmodel

import androidx.lifecycle.*
import com.ezylaw.lawbook.model.Particular
import com.ezylaw.lawbook.room.ParticularRepository
import kotlinx.coroutines.launch

class UserDetailViewModel(private val userRepository: ParticularRepository) : ViewModel() {

    val allParticular: LiveData<MutableList<Particular>> =
        userRepository.getAllUserList.asLiveData()


    // Launching a new coroutine to insert the data in a non-blocking way
    fun insertUser(particular: Particular) = viewModelScope.launch {
        userRepository.insertUser(particular)
    }

    class PracticeViewModelFactory(private val particularRepository: ParticularRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserDetailViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return UserDetailViewModel(particularRepository) as T
            }
            throw IllegalArgumentException("Unknown VieModel Class")
        }

    }
}
