package com.example.expensestracker.Expense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.expensestracker.Groep.GroepLijstFragment
import com.example.expensestracker.MainActivity
import com.example.expensestracker.R
import com.example.expensestracker.databinding.FragmentAddexpenseBinding
import com.example.expensestracker.model.Expense
import com.example.expensestracker.model.Groep
import com.example.expensestracker.model.GroepLijstPreferencesRepository
import com.example.expensestracker.model.GroepLijstRepository

class AddExpenseFragment: Fragment(R.layout.fragment_addexpense)  {

    private lateinit var binding: FragmentAddexpenseBinding
    private lateinit var main: MainActivity
    private val expensesLijst = mutableListOf<Expense>()
    private lateinit var groepLijstRepository: GroepLijstRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddexpenseBinding.inflate(layoutInflater)
        main = activity as MainActivity
        groepLijstRepository = GroepLijstPreferencesRepository(requireActivity())
        binding.btnAddExpense.setOnClickListener{
            addExpense()
        }
        return binding.root
    }

    private fun addExpense(){
        val expense = Expense(binding.txtExpenseNaam.text.toString(), binding.txtExpenseBedrag.toString().toInt())
        expensesLijst.add(expense)

        findNavController().navigate(R.id.action_addExpenseFragment_to_expenseLijstFragment)
    }

}