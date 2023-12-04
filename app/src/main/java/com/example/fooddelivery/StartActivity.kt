package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val startMainActivity: Button = findViewById(R.id.saButton)
        startMainActivity.setOnClickListener {
            startActivity(Intent(this,LoginScreen::class.java))
        }

    }
}