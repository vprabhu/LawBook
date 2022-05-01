package com.ezylaw.lawbook

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ezylaw.lawbook.model.User
import com.ezylaw.lawbook.viewmodel.UserLogInViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var userIdEditText: EditText
    private lateinit var addButton: Button

    private val userLogInViewModel: UserLogInViewModel by viewModels {
        UserLogInViewModel.UserViewModelFactory((application as LbApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userIdEditText = findViewById(R.id.userIdTextView)
        addButton = findViewById(R.id.addButton)

        addButton.setOnClickListener(View.OnClickListener {
            val user = User(
                userIdEditText.text.toString(),
                "222dddxxx" + userIdEditText.text.toString(),
                "Lawyer",
                "Hamid",
                "abdul",
                "abdul@gmail.com",
                "9999999999",
                "11/22/2000",
                "M",
                3,
                "BCA",
                "ddddtTtddzz1111122",
                "Patna",
            )
            userLogInViewModel.insertUser(user)
        })

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        userLogInViewModel.allUser.observe(this) { users ->
            // Update the cached copy of the words in the adapter.
            users.let {
                for (user in users) {
                    Log.d("**************", user.first)
                }

            }
        }

    }
}