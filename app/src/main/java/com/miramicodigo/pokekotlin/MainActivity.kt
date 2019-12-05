package com.miramicodigo.pokekotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miramicodigo.pokekotlin.adapter.PokemonAdapter
import com.miramicodigo.pokekotlin.model.PokemonResponse
import com.miramicodigo.pokekotlin.service.PokeInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var retrofit: Retrofit
    lateinit var listaPokemonAdapter: PokemonAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager
    var cantidadLote = 0
    var sePuedeCargar = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaPokemonAdapter = PokemonAdapter(this)
        recyclerView.adapter = listaPokemonAdapter
        layoutManager = GridLayoutManager(this, 3)
        recyclerView.layoutManager = layoutManager

        retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        cantidadLote = 0
        sePuedeCargar = true
        obtenerDatos(cantidadLote)

        recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(dy > 0) {
                    val visibleCount = layoutManager.childCount
                    val totalItemCount = layoutManager.itemCount
                    val firtItemVisible = (layoutManager as GridLayoutManager).findFirstVisibleItemPosition()

                    if(sePuedeCargar) {
                        if(visibleCount + firtItemVisible >= totalItemCount) {
                            sePuedeCargar = false
                            cantidadLote+= 20
                            obtenerDatos(cantidadLote)
                        }
                    }
                }
            }
        })

    }

    private fun obtenerDatos(offset: Int) {
        val service = retrofit.create(PokeInterface::class.java)
        val pokemonResponseCall = service.obtenerListaPokemon(offset, 20)

        pokemonResponseCall.enqueue(object: Callback<PokemonResponse> {
            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
                sePuedeCargar = true
                if(response?.isSuccessful) {
                    val pokemonResponse = response.body()
                    val listaPokemon = pokemonResponse?.results
                    listaPokemonAdapter.adicionarListaPokemon(listaPokemon!!)
                }
            }
        })

    }

}