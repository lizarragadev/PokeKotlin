package com.miramicodigo.pokekotlin.service

import com.miramicodigo.pokekotlin.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeInterface {

    @GET("pokemon")
    fun obtenerListaPokemon(
            @Query("offset") offset: Int,
            @Query("limit") limit: Int
    ): Call<PokemonResponse>
}