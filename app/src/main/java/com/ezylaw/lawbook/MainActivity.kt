package com.ezylaw.lawbook

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ezylaw.lawbook.model.User
import com.ezylaw.lawbook.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {


    private val userViewModel: UserViewModel by viewModels {
        UserViewModel.UserViewModelFactory((application as LbApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var user = User(11, "222dddxxx", "Hamid", "9999993333", 22)
        userViewModel.insertUser(user)

        user = User(11, "222dddxxx11", "Hamid", "9999993333", 22)
        userViewModel.updateUser(user)

    }
}