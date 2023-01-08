package com.example.pokedexxcarethetr.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexxcarethetr.databinding.ItemRecyclerBinding
import com.example.pokedexxcarethetr.models.pokemon

class adapterRecycler  (
    private val pokeList: ArrayList<pokemon>,
    private val listener: (pokemon, Int) -> Unit
) :
    RecyclerView.Adapter<adapterRecycler.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(pokeList[position])
        holder.itemView.setOnClickListener { listener(pokeList[position], position) }
    }

    override fun getItemCount(): Int {
        return pokeList.size
    }

    class ViewHolder(var itemBinding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(pokemon: pokemon) {
           itemBinding.imagePoke.setImageResource(pokemon.image)
            itemBinding.namePokemon.text= pokemon.name
        }
    }



}