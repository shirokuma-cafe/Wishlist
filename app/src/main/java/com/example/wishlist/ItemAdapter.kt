package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (private val items: ArrayList<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTV: TextView
        val priceTV: TextView
        val urlTV: TextView

        init {
            nameTV = itemView.findViewById(R.id.itemNameTV)
            priceTV = itemView.findViewById(R.id.itemPriceTV)
            urlTV = itemView.findViewById(R.id.itemURLTV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        val item: Item = items[position]
        holder.nameTV.text = item.name
        holder.priceTV.text = item.price
        holder.urlTV.text = item.URL

    }
}