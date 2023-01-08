package com.example.pokedexxcarethetr.Views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedexxcarethetr.Adapters.adapterRecycler
import com.example.pokedexxcarethetr.R
import com.example.pokedexxcarethetr.controllers.controllerSession
import com.example.pokedexxcarethetr.databinding.ActivityHomeBinding
import com.example.pokedexxcarethetr.models.pokemon

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setView()


        setupRecyclerView()


    }


    fun setView(){

        var btnCerrarSession = binding.btnCloseSessionHome;
        btnCerrarSession.setOnClickListener(View.OnClickListener {
            var sessionInit = controllerSession(this)
            sessionInit.deleteSession();
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }

    private fun setupRecyclerView() {

        binding.recyclerviewPokemons.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterRecycler(createHeroList()) { pokemon, position ->
                goToScreen(pokemon.name)
            }
        }
    }

fun goToScreen(name: String){
    var intent = Intent(this, DetailsActivity::class.java)
    intent.putExtra("nombre", name)
    startActivity(intent)
}
    private fun createHeroList(): ArrayList<pokemon> {
        return arrayListOf<pokemon>(
            pokemon(
                "Bulbasaur",
                R.drawable.bulbasaur
            ),
            pokemon(
                "Charizard",
                R.drawable.charizard
            ),
            pokemon(
                "Pikachu",
                R.drawable.pikachu
            ),
            pokemon(
                "Squirtle",
                R.drawable.squirtle
            )
        )
    }


}