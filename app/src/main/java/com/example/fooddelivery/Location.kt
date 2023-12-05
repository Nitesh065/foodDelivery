package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView

class Location : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        var locationList = arrayOf<String>("Indore","Bhopal","Ujjain")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)
        val tvAutocomplete = findViewById<AutoCompleteTextView>(R.id.tvAutoComplete)
        tvAutocomplete.setAdapter(adapter)
        val btnLocation: Button = findViewById(R.id.btnLocation)
        btnLocation.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}