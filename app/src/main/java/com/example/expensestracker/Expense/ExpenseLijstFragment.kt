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
import com.example.expensestracker.model.ExpensePreferencesRepository
import com.example.expensestracker.model.ExpenseRepository


class ExpenseLijstFragment : Fragment(R.layout.fragment_expenselijst) {
    private val expenselijst = arrayListOf<Expense>()
    private lateinit var binding: FragmentExpenselijstBinding
    private lateinit var main: MainActivity
    private lateinit var adapter: ExpenseLijstAdapter
    private lateinit var expenseRepository: ExpenseRepository


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExpenselijstBinding.inflate(layoutInflater)
        main = activity as MainActivity

        expenseRepository = ExpensePreferencesRepository(requireActivity())

        laadExpenses()

        adapter = ExpenseLijstAdapter(expenselijst)
        binding.rvExpenseLijst.adapter = adapter
        binding.rvExpenseLijst.layoutManager = LinearLayoutManager(this.context)



        binding.btnAddExpense.setOnClickListener {
            findNavController().navigate(R.id.action_expenseLijstFragment_to_addExpenseFragment)
        }

        binding.btnVerwijderExpenses.setOnClickListener {
            findNavController().navigate(R.id.action_expenseLijstFragment_to_deleteExpenseFragment)
        }
        return binding.root
    }

    private fun laadExpenses() {
        expenselijst.clear()
        expenselijst.addAll(expenseRepository.loadExpenses())
    }

    fun selecteerExpense(expense: Expense) {
        findNavController().navigate(
            R.id.action_expenseLijstFragment_to_expenseDetailFragment,
            bundleOf("naam" to expense.getNaam())
        )
    }
}