package com.example.expensestracker.Expense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensestracker.MainActivity
import com.example.expensestracker.R
import com.example.expensestracker.databinding.FragmentExpenselijstBinding
import com.example.expensestracker.model.Expense
import com.example.expensestracker.model.Groep


class ExpenseLijstFragment: Fragment(R.layout.fragment_expenselijst) {
    private lateinit var binding: FragmentExpenselijstBinding

    private lateinit var adapter: ExpenseLijstAdapter
    private var expenselijst = listOf<Expense>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExpenselijstBinding.inflate(layoutInflater)


        adapter = ExpenseLijstAdapter(expenselijst)
        binding.rvExpenseLijst.adapter = adapter
        binding.rvExpenseLijst.layoutManager = LinearLayoutManager(this.context)


        binding.btnAddExpense.setOnClickListener{
            findNavController().navigate(R.id.action_expenseLijstFragment_to_addExpenseFragment)
        }
        return binding.root
    }

   override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }



   fun selecteerExpense(expense: Expense){
        findNavController().navigate(R.id.action_expenseLijstFragment_to_expenseDetailFragment, bundleOf(Expense.EXPENSE_ID to expense.id.toString()))
   }

}