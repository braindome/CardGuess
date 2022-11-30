package com.example.cardguess

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class DrawHistoryAdapter(val context : Context, val history : List<Card>) : RecyclerView.Adapter<DrawHistoryAdapter.ViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_layout, parent, false)

        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = CardDeck.pastCards[position]

        holder.valueText.text = "Card value: ${card.value}"
        holder.cardImage.setImageResource(card.image)
    }

    override fun getItemCount(): Int {
        return CardDeck.pastCards.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val valueText = itemView.findViewById<TextView>(R.id.historyCardValue)
        val cardImage = itemView.findViewById<ImageView>(R.id.historyCardImg)
    }

}