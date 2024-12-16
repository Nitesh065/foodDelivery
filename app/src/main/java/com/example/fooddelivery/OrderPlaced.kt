package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OrderPlaced : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_placed)

        val btnReturnHome: Button = findViewById(R.id.btnGoHome)
        btnReturnHome.setOnClickListener {
           startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}