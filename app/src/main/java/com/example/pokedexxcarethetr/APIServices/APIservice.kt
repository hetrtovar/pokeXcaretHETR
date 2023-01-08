package com.example.pokedexxcarethetr.APIServices

import retrofit2.http.GET
import retrofit2.http.Url

interface APIservice {
    interface APIService {
        @GET
        suspend fun getPokemonByNombre(@Url url:String):pokeResponse
    }
}