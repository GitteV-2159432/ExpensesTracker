package com.example.expensestracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.findFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.expensestracker.model.Groep

class GroepLijstAdapter(val items: List<Groep>): RecyclerView.Adapter<GroepLijstAdapter.GroepLijstViewHolder>() {
    private lateinit var parentFragment: GroepLijstFragment

    inner class GroepLijstViewHolder(currentItemView: View): RecyclerView.ViewHolder(currentItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroepLijstViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_groep, parent, false)
        parentFragment = parent.findFragment()
        return GroepLijstViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroepLijstViewHolder, position: Int) {
        val groep = items[position]
        holder.itemView.apply {
            setOnClickListener{
                parentFragment.selecteerGroep(groep)
                true
            }

            findViewById<TextView>(R.id.txtActiviteitnaam).text = groep.naam
            findViewById<TextView>(R.id.txtbedrag).text = '€' + groep.bedrag.toString()

        }
    }

    override fun getItemCount(): Int = items.size
}