package com.example.expensestracker.Expense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.expensestracker.MainActivity
import com.example.expensestracker.R
import com.example.expensestracker.databinding.FragmentAddexpenseBinding
import com.example.expensestracker.model.Expense
import com.example.expensestracker.model.Groep
import com.example.expensestracker.model.GroepLijstPreferencesRepository

class AddExpenseFragment: Fragment(R.layout.fragment_addexpense)  {

    private lateinit var binding: FragmentAddexpenseBinding
    private lateinit var main: MainActivity
    private lateinit var groepLijstRepository: GroepLijstPreferencesRepository
    private lateinit var groep: Groep

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddexpenseBinding.inflate(layoutInflater)
        main = activity as MainActivity
        groepLijstRepository = GroepLijstPreferencesRepository(requireActivity())
        val groepNaam = arguments?.getString("naam")
        groep = groepLijstRepository.getGroep(groepNaam)
        binding.btnAddExpense.setOnClickListener{
            addExpense()
        }
        return binding.root
    }

    private fun addExpense(){
        val bedrag = binding.txtExpenseBedrag.text.toString().toDouble()
        val expense = Expense(binding.txtExpenseNaam.text.toString(), bedrag)

        groep.addExpense(expense)
        groepLijstRepository.saveGroep(groep)
        findNavController().navigate(R.id.action_addExpenseFragment_to_expenseLijstFragment)
    }

}