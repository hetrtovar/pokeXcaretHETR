package com.example.pokedexxcarethetr.Views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexxcarethetr.APIServices.APIservice
import com.example.pokedexxcarethetr.Adapters.adapterAbilidades
import com.example.pokedexxcarethetr.R
import com.example.pokedexxcarethetr.databinding.ActivityDetailsBinding
import com.example.pokedexxcarethetr.models.itemAbiliti
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    var namePoke: String = ""
    private lateinit var txtHP: TextView
    private lateinit var txtNombre: TextView
    private lateinit var imgPoke : ImageView
    private lateinit var adapterA: adapterAbilidades
    private lateinit var listview: RecyclerView

    private lateinit var abilidades: ArrayList<itemAbiliti>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        namePoke = intent.getStringExtra("nombre").toString()
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var btnBack = binding.btnBack
        btnBack.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, HomeActivity::class.java)

            startActivity(intent)
            finish()
        })


        searchByName(namePoke)
        abilidades = ArrayList()
        setupRecyclerView(abilidades)

    }


    private fun setupRecyclerView(lista: ArrayList<itemAbiliti>) {
        listview = binding.listAbilities
        adapterA = adapterAbilidades(abilidades)
        listview.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapterA
        }


    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/pokemon/" )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


    fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIservice.APIService::class.java).getPokemonByNombre(namePoke.toLowerCase())
                Log.d("TagBuscar", call.abilities[0].ability.name)
            txtHP = binding.txtViewHp
            txtNombre = binding.nombrePokeEdt
            txtNombre.text = namePoke
            imgPoke = binding.imgPokemon
            abilidades = call.abilities


            runOnUiThread {
                // Stuff that updates the UI
                adapterA = adapterAbilidades(abilidades)
                listview.adapter = adapterA
                adapterA.notifyDataSetChanged()
            }





            val random1 = (0..100).shuffled().last()
            txtHP.text = "HP "+random1

            when (namePoke) {
                "Bulbasaur" -> imgPoke.setImageDrawable(getDrawable(R.drawable.bulbasaur))
                "Charizard" -> imgPoke.setImageDrawable(getDrawable(R.drawable.charizard))
                "Pikachu" -> imgPoke.setImageDrawable(getDrawable(R.drawable.pikachu))
                "Squirtle" -> imgPoke.setImageDrawable(getDrawable(R.drawable.squirtle))
            }
        }
    }


}