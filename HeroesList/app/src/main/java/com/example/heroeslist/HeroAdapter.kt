package com.example.heroeslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class HeroAdapter(
    private val heroes: List<Hero>,
    private val click: (Hero) -> Unit
): Adapter<HeroAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val heroImg = itemView.findViewById<ImageView>(R.id.hImage)
        val heroNm = itemView.findViewById<TextView>(R.id.nome)
        val heroOrg = itemView.findViewById<TextView>(R.id.origem)

        fun bind(hero: Hero){
            heroImg.setImageResource(hero.heroImage)
            heroNm.text = hero.heroName
            heroOrg.text = hero.heroCompany
            itemView.setOnClickListener{click(hero)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroAdapter.ViewHolder, position: Int) {
        holder.bind(heroes[position])
    }

    override fun getItemCount(): Int {
        return heroes.size
    }
}