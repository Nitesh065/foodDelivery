package com.example.fooddelivery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R
import com.example.fooddelivery.model.historyData

class HistoryRecycleAdapter (private val context: Context, private val historyData: List<historyData>):
    RecyclerView.Adapter<HistoryRecycleAdapter.ListHolder>() {
    class ListHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun Bind(history: historyData) {
            val ivHistory: ImageView = itemView.findViewById(R.id.ivHistory)
            val tvHistoryItemName: TextView = itemView.findViewById(R.id.tvMenuItemName)
            val tvHistoryItemPrice: TextView = itemView.findViewById(R.id.tvMenuItemPrice)
            val tvHistoryNameType: TextView = itemView.findViewById(R.id.tvMenu3)
            ivHistory.setImageResource(history.image)
            tvHistoryItemName.text = history.name
            tvHistoryItemPrice.text = history.price
            tvHistoryNameType.text = history.foodType

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        return ListHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.history_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return historyData.size
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.Bind(historyData[position])
    }
}
