package com.droidapps.igymhealth.data.cards

import androidx.recyclerview.widget.RecyclerView
import com.droidapps.igymhealth.databinding.CardCellBinding

class CardViewHolder (
    private val cardCellBinding: CardCellBinding,
    private val clickListener: CardClickListener
    ): RecyclerView.ViewHolder(cardCellBinding.root) {
    fun bindCards(cards: Cards){
        cardCellBinding.cover.setImageResource(cards.icon)
        cardCellBinding.workout.text = cards.workout
        cardCellBinding.type.text = cards.type

        cardCellBinding.cardViewID.setOnClickListener{
            clickListener.onClick(cards)
        }
    }
}