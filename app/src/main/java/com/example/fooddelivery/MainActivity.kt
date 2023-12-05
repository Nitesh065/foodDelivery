package com.example.fooddelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fooddelivery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var homeFragment = Home()
    private var cartFragment = Cart()
    private var menuFragment = menu()
    private var userFragment = user()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        loadFragment(homeFragment)

        binding.bottomNavigation.setOnItemSelectedListener {item ->
            when(item.itemId){
                R.id.navigation_home -> loadFragment(homeFragment)
               R.id.navigation_cart -> loadFragment(cartFragment)
               R.id.navigation_menu -> loadFragment(menuFragment)
                R.id.navigation_user -> loadFragment(userFragment)
            }
            true
        }
    }
    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit()
    }
}