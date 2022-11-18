package com.droidapps.igymhealth.data.cards

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.droidapps.igymhealth.databinding.CardCellBinding

class CardAdapter(private val cards: List<Cards>,
    private val clickListener: CardClickListener)
: RecyclerView.Adapter<CardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardCellBinding.inflate(from, parent, false)
        return CardViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindCards(cards[position])
    }

    override fun getItemCount(): Int = cards.size
}