package com.example.pokedexxcarethetr.APIServices

import com.example.pokedexxcarethetr.models.itemAbiliti
import com.google.gson.annotations.SerializedName

class pokeResponse(name: String, image: Int, abilities : ArrayList<itemAbiliti>) {
    @SerializedName("name") var name: String = ""
    @SerializedName("abilities") var abilities = ArrayList<itemAbiliti>()
    var image = 0;

    init {
        this.name = name
        this.image = image
        this.abilities = abilities
    }
}