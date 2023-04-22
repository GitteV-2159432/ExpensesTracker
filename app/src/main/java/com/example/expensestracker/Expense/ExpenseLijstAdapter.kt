package com.example.expensestracker.Expense

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.findFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.expensestracker.R
import com.example.expensestracker.model.Expense
import java.util.*

class ExpenseLijstAdapter(val items: List<Expense>): RecyclerView.Adapter<ExpenseLijstAdapter.ExpenseLijstViewHolder>() {
    private lateinit var parentFragment: ExpenseLijstFragment

    inner class ExpenseLijstViewHolder(currentItemView: View): RecyclerView.ViewHolder(currentItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseLijstViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_expense, parent, false)
        parentFragment = parent.findFragment()
        return ExpenseLijstViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseLijstViewHolder, position: Int) {
        val expense = items[position]
        holder.itemView.apply {
            setOnClickListener{
               parentFragment.selecteerExpense(expense)
                true
            }

            findViewById<TextView>(R.id.txtExpenseNaam).text = expense.naam
            findViewById<TextView>(R.id.txtbedrag).text = '€' + expense.bedrag.toString()
            val date = Calendar.getInstance().time
            findViewById<TextView>(R.id.txtDatum).text = date.toString()

        }
    }

    override fun getItemCount(): Int = items.size
}