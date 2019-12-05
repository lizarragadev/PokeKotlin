package com.miramicodigo.pokekotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miramicodigo.pokekotlin.R
import com.miramicodigo.pokekotlin.model.Pokemon

class PokemonAdapter(private val context: Context) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    private val dataset: ArrayList<Pokemon> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_poke, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png


    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun adicionarListaPokemon(listaPokemon: ArrayList<Pokemon>) {
        dataset.addAll(listaPokemon)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }
}