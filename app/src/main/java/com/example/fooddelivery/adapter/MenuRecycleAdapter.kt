package com.example.fooddelivery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R
import com.example.fooddelivery.model.menuData

class MenuRecycleAdapter (private val context: Context, private val menuData: List<menuData>):RecyclerView.Adapter<MenuRecycleAdapter.ListHolder>() {
    class ListHolder(view: View): RecyclerView.ViewHolder(view) {
        fun Bind(menu: menuData){
            val ivMenu: ImageView = itemView.findViewById(R.id.ivMenuCard)
            val tvMenuName: TextView = itemView.findViewById(R.id.tvitemName)
            val tvMenuPrice: TextView = itemView.findViewById(R.id.tvitemPrice)
            val tvMenuType: TextView = itemView.findViewById(R.id.tvMenu3)
            ivMenu.setImageResource(menu.image)
            tvMenuName.text = menu.name
            tvMenuPrice.text = menu.price
            tvMenuType.text = menu.food_type

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        return ListHolder(LayoutInflater.from(parent.context).inflate(R.layout.menu_item,parent,false))
    }

    override fun getItemCount(): Int {
        return menuData.size
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.Bind(menuData[position])
    }
}