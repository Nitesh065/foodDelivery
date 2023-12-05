package com.example.fooddelivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fooddelivery.databinding.FragmentCartBinding
import com.example.fooddelivery.databinding.FragmentMenuBinding


class menu : Fragment() {


    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater,container,false)
        binding.tvMenu.text = "Menu Screen"
        // Inflate the layout for this fragment
        return binding.root
    }
}