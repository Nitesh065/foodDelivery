package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OrderDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)

        val btnOrderPlace: Button = findViewById(R.id.btnPlaceOrder)
        btnOrderPlace.setOnClickListener {
            startActivity(Intent(this,OrderPlaced::class.java))
            finish()
        }
    }
}