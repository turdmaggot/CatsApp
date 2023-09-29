package com.reinertupaz.cats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.reinertupaz.cats.R
import com.reinertupaz.cats.rest.Cat
import com.squareup.picasso.Picasso

class CatsAdapter (private val listCats: List<Cat>) : RecyclerView.Adapter<CatsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cats_row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cat = listCats[position]
        holder.imgCat.getLayoutParams().height = cat.height
        holder.imgCat.getLayoutParams().width = cat.width
        Picasso.get().load(cat.url).into(holder.imgCat);
    }

    override fun getItemCount(): Int {
        return listCats.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imgCat: ImageView = itemView.findViewById(R.id.imgCat)
    }
}