package be.GitteWout.expensestracker.Expense

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.expensestracker.R
import be.GitteWout.expensestracker.model.Expense

class DeleteExpenseAdapter(
    val expenselijst: List<Expense>,
    val deleteExpenseLijst: ArrayList<Expense>
) : RecyclerView.Adapter<DeleteExpenseAdapter.DeleteExpenseViewHolder>() {
    private val checkedExpenseList = ArrayList<Int>()

    inner class DeleteExpenseViewHolder(currentItemView: View) :
        RecyclerView.ViewHolder(currentItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeleteExpenseViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_expense_delete, parent, false)
        return DeleteExpenseViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeleteExpenseViewHolder, position: Int) {
        val currentItem = expenselijst[position]
        holder.itemView.apply {
            val checkBox = findViewById<CheckBox>(R.id.checkBoxDeleteExpense)
            checkBox.text = currentItem.getNaam()
            checkBox.isChecked = checkedExpenseList.contains(position)

            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    deleteExpenseLijst.add(currentItem)
                } else {
                    deleteExpenseLijst.remove(currentItem)
                }
            }
        }
    }

    override fun getItemCount(): Int = expenselijst.size

}