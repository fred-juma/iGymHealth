package com.droidapps.igymhealth.data.cards

var cardList = mutableListOf<Cards>()
var ID_EXTRA = "Sample ID"

class Cards (
    var icon: Int,
    var workout: String,
    var type: String,
    val id: Int? = cardList.size
        )