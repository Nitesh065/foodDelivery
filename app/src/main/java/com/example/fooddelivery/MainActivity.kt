package com.example.fooddelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.fooddelivery.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

//    private var homeFragment = Home()
//    private var cartFragment = Cart()
//    private var menuFragment = menu()
//    private var userFragment = user()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    var navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
    var navController = navHostFragment.navController
    var bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
    bottomNav.setupWithNavController(navController)
//        loadFragment(homeFragment)

//        binding.bottomNavigation.setOnItemSelectedListener {item ->
//            when(item.itemId){
//                R.id.navigation_home -> loadFragment(homeFragment)
//               R.id.navigation_cart -> loadFragment(cartFragment)
//               R.id.navigation_menu -> loadFragment(menuFragment)
//                R.id.navigation_user -> loadFragment(userFragment)
//            }
//            true
//        }
    }

}