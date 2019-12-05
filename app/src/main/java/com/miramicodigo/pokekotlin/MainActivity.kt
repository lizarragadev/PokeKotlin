package com.miramicodigo.pokekotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.miramicodigo.pokekotlin.adapter.PokemonAdapter
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    lateinit var retrofit: Retrofit
    lateinit var listaPokemonAdapter: PokemonAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager
    var cantidadLote = 0
    var sePuedeCargar = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    private fun obtenerDatos(offset: Int) {


    }

}