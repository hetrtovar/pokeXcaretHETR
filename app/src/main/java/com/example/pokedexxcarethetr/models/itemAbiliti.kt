package com.example.pokedexxcarethetr.models

import com.google.gson.annotations.SerializedName

class itemAbiliti(is_hidden : Boolean, slot: Int, ability : ability) {

    @SerializedName("is_hidden")
    var is_hidden=  false

    @SerializedName("slot")
    var slot = 0

    @SerializedName("ability")
    lateinit var ability : ability

}