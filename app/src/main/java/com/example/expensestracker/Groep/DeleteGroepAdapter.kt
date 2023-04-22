package com.example.expensestracker.Groep

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.expensestracker.R
import com.example.expensestracker.model.Groep

class DeleteGroepAdapter(val groeplijst: List<Groep>, val deleteGroepLijst: ArrayList<Groep>): RecyclerView.Adapter<DeleteGroepAdapter.DeleteGroepViewHolder>() {
    private val checkedGroepLijst = ArrayList<Int>()
    inner class DeleteGroepViewHolder(currentItemView: View): RecyclerView.ViewHolder(currentItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeleteGroepViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_groep_delete, parent, false)
        return DeleteGroepViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeleteGroepViewHolder, position: Int) {
        val currentItem = groeplijst[position]
        holder.itemView.apply {
            val checkBox = findViewById<CheckBox>(R.id.checkBoxDeleteGroep)
            checkBox.text = currentItem.naam
            checkBox.isChecked = checkedGroepLijst.contains(position)

            checkBox.setOnCheckedChangeListener{_, isChecked ->
                if(isChecked){
                    deleteGroepLijst.add(currentItem)
                }else{
                    deleteGroepLijst.remove(currentItem)
                }
            }
        }
    }

    override fun getItemCount(): Int = groeplijst.size
}