package com.ezylaw.lawbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ezylaw.lawbook.room.User
import com.ezylaw.lawbook.viewmodel.WordViewModel
import com.ezylaw.lawbook.viewmodel.WordViewModelFactory

class MainActivity : AppCompatActivity() {


    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as LawBookApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val word = User("Names")
        wordViewModel.insert(word)
    }
}