package com.ezylaw.lawbook

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ezylaw.lawbook.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels {
        UserViewModel.UserViewModelFactory((application as LawBookApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        userViewModel.allUser.observe(this, { userList ->
            userList?.let {
                AlertDialog.Builder(this).setMessage(userList[0].name).show()
            }
        })
    }
}