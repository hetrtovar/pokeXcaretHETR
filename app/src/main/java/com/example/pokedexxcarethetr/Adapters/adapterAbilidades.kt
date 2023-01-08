package com.example.pokedexxcarethetr.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexxcarethetr.R
import com.example.pokedexxcarethetr.databinding.ItemListBinding
import com.example.pokedexxcarethetr.databinding.ItemRecyclerBinding
import com.example.pokedexxcarethetr.models.itemAbiliti
import com.example.pokedexxcarethetr.models.pokemon

class adapterAbilidades  (
    private val pokeList: ArrayList<itemAbiliti>,
) :
    RecyclerView.Adapter<adapterAbilidades.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(pokeList[position])

    }

    override fun getItemCount(): Int {
        return pokeList.size
    }

    class ViewHolder(var itemBinding: ItemListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(abilidad: itemAbiliti) {
            /*
   itemBinding.imagePoke.setImageResource(pokemon.image)
   itemBinding.namePokemon.text= pokemon.name*/



            val random1 = (0..100).shuffled().last()
            if(random1 > 0 && random1 < 25){
                itemBinding.esfera1.setImageResource(R.drawable.circulo_verde)
                itemBinding.esfera2.setImageResource(R.drawable.circulo_vacio)
                itemBinding.esfera3.setImageResource(R.drawable.circulo_vacio)
                itemBinding.esfera4.setImageResource(R.drawable.circulo_vacio)




            }else if(random1 >= 25 && random1 < 50){

                itemBinding.esfera1.setImageResource(R.drawable.circulo_verde)
                itemBinding.esfera2.setImageResource(R.drawable.circulo_verde)
                itemBinding.esfera3.setImageResource(R.drawable.circulo_vacio)
                itemBinding.esfera4.setImageResource(R.drawable.circulo_vacio)


            }else if(random1 >= 50 && random1 < 75){

                itemBinding.esfera1.setImageResource(R.drawable.circulo_verde)
                itemBinding.esfera2.setImageResource(R.drawable.circulo_verde)
                itemBinding.esfera3.setImageResource(R.drawable.circulo_verde)
                itemBinding.esfera4.setImageResource(R.drawable.circulo_vacio)


            }else if(random1 >= 75 ){
                itemBinding.esfera1.setImageResource(R.drawable.circulo_verde)
                itemBinding.esfera2.setImageResource(R.drawable.circulo_verde)
                itemBinding.esfera3.setImageResource(R.drawable.circulo_verde)
                itemBinding.esfera4.setImageResource(R.drawable.circulo_verde)

            }

            itemBinding.nombreCalif.text = abilidad.ability.name+"  "+random1



        }
    }



}