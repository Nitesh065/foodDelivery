package com.example.fooddelivery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R
import com.example.fooddelivery.model.Cartdata

class CartRecycleAdapter(private val context: Context, private val cartData: MutableList<Cartdata>):
    RecyclerView.Adapter<CartRecycleAdapter.ListHolder>() {

    class ListHolder(view: View):RecyclerView.ViewHolder(view) {
        fun Bind(cart: Cartdata){
            val ivCartImage: ImageView = itemView.findViewById(R.id.ivMenuCart)
            val tvCartName: TextView = itemView.findViewById(R.id.tvCartItemName)
            val tvCartPrice: TextView = itemView.findViewById(R.id.tvCartItemPrice)
            val tvCartQuantity: TextView = itemView.findViewById(R.id.tvQuantity)
            val quantityAdd: ImageButton = itemView.findViewById(R.id.btnQuntityAdd)
            val quantityMinus: ImageButton = itemView.findViewById(R.id.btnQuntityMIns)
            if (cart.quantity>=0){
                quantityAdd.setOnClickListener {
                    tvCartQuantity.text = cart.quantity++.toString()

                    quantityMinus.setOnClickListener {
                        tvCartQuantity.text = cart.quantity--.toString()
                    }
            }


            }
            else{
               tvCartQuantity.text = "0"
            }

            ivCartImage.setImageResource(cart.image)
            tvCartName.text = cart.itemName
            tvCartPrice.text = cart.itemPrice




        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartRecycleAdapter.ListHolder {
        return ListHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
       return cartData.size
    }

    override fun onBindViewHolder(holder: CartRecycleAdapter.ListHolder, position: Int) {
        holder.Bind(cartData[position])

        var btnDelete = holder.itemView.findViewById<ImageButton>(R.id.btnDelete)
        btnDelete.setOnClickListener {
            cartData.removeAt(position)
            notifyDataSetChanged()
        }
        }


    }

