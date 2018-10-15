package com.miramicodigo.restful1.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.miramicodigo.restful1.R
import com.miramicodigo.restful1.model.Pokemon
import kotlinx.android.synthetic.main.activity_detalle.*

class DetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)
        supportActionBar!!.hide()

        val pokemon = intent.getSerializableExtra("poke") as Pokemon
        tvDetalleTitulo.text = pokemon.name

        Glide.with(this)
                .load("http://pokeapi.co/media/sprites/pokemon/" + pokemon.number + ".png")
                .into(ivDetalleImagen)

    }
}
