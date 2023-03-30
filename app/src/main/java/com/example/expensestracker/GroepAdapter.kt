package com.example.expensestracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expensestracker.model.Groep


class GroepAdapter (val items: List<Groep>): RecyclerView.Adapter<GroepAdapter.ActiviteitViewHolder>() {

    inner class ActiviteitViewHolder(currentItemView: View): RecyclerView.ViewHolder(currentItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiviteitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.groep, parent, false)
        return ActiviteitViewHolder(view)
    }
    override fun onBindViewHolder(holder: ActiviteitViewHolder, position: Int){
        val currentActiviteitItem = items[position]
        holder.itemView.apply {
            findViewById<TextView>(R.id.txtActiviteitnaam).text = currentActiviteitItem.naam
            findViewById<TextView>(R.id.txtbedrag).text= "€" + currentActiviteitItem.bedrag.toString()
        }
    }
    override fun getItemCount(): Int = items.size
}

