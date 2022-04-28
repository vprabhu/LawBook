package com.ezylaw.lawbook

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ezylaw.lawbook.model.User
import com.ezylaw.lawbook.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var userIdEditText: EditText
    private lateinit var addButton: Button

    private val userViewModel: UserViewModel by viewModels {
        UserViewModel.UserViewModelFactory((application as LbApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userIdEditText = findViewById(R.id.userIdTextView)
        addButton = findViewById(R.id.addButton)

        addButton.setOnClickListener(View.OnClickListener {
            val user = User(
                userIdEditText.text.toString().toLong(),
                "222dddxxx" + userIdEditText.text.toString(),
                "Hamid",
                "9999993333",
                22
            )
            userViewModel.insertUser(user)
        })

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        userViewModel.allUser.observe(this) { users ->
            // Update the cached copy of the words in the adapter.
            users.let {
                for (user in users) {
                    Log.d("**************", user.name)
                }

            }
        }

    }
}