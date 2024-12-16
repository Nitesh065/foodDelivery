package com.example.fooddelivery.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.Cart
import com.example.fooddelivery.R
import com.example.fooddelivery.model.homeData

class HomeRecycleAdapter (private val context: Context, private val menuData: List<homeData>):RecyclerView.Adapter<HomeRecycleAdapter.ListHolder>() {
    class ListHolder(view: View): RecyclerView.ViewHolder(view) {
        fun Bind(menu: homeData){
            val ivMenu: ImageView = itemView.findViewById(R.id.ivMenu)
            val tvMenuName: TextView = itemView.findViewById(R.id.tvMenuItemName)
            val tvMenuPrice: TextView = itemView.findViewById(R.id.tvMenuItemPrice)
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
        val item = holder.itemView.findViewById<TextView>(R.id.tvMenu3)
        val activity: FragmentActivity = context as FragmentActivity
        item.setOnClickListener {
            val fragment: Fragment = Cart()
            val args = Bundle()
            args.putString("name",menuData[position].name)
            args.putString("price",menuData[position].price)
            args.putInt("image",menuData[position].image)
            fragment.arguments = args

            activity.supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView2,fragment).addToBackStack(null).commit()




        }

    }
}