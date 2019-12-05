package com.miramicodigo.pokekotlin.adapter

import android.content.Context
import android.graphics.Typeface
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miramicodigo.pokekotlin.R
import com.miramicodigo.pokekotlin.model.Pokemon

class PokemonAdapter(private val context: Context) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    private val dataset: ArrayList<Pokemon> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_poke, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = dataset[position]

        // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png

        holder.nombreTextView.text = p.name
        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${p.number}.png")
                .into(holder.fotoImageView)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun adicionarListaPokemon(listaPokemon: ArrayList<Pokemon>) {
        dataset.addAll(listaPokemon)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fotoImageView = itemView.findViewById(R.id.ivImagen) as ImageView
        val nombreTextView = itemView.findViewById(R.id.tvNombre) as TextView
    }
}