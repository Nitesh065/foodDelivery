
package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegisterScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)
        val textButton: TextView = findViewById(R.id.t4Register)
        textButton.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}