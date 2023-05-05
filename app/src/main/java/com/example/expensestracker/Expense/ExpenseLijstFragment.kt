package com.example.expensestracker.Expense

import android.os.Bundle
import android.security.ConfirmationCallback
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensestracker.MainActivity
import com.example.expensestracker.R
import com.example.expensestracker.databinding.FragmentExpenselijstBinding
import com.example.expensestracker.model.Expense
import com.example.expensestracker.model.Groep
import com.example.expensestracker.model.GroepLijstPreferencesRepository
import com.example.expensestracker.model.GroepLijstRepository


class ExpenseLijstFragment: Fragment(R.layout.fragment_expenselijst) {
    private val expenselijst = arrayListOf<Expense>()


    private lateinit var binding: FragmentExpenselijstBinding
    private lateinit var main: MainActivity
    private lateinit var adapter: ExpenseLijstAdapter
    private lateinit var groepLijstRepository: GroepLijstPreferencesRepository
    private lateinit var groep: Groep

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExpenselijstBinding.inflate(layoutInflater)
        main = activity as MainActivity

        val groepNaam = arguments?.getString("naam")


        groepLijstRepository = GroepLijstPreferencesRepository(requireActivity())
        groep = groepLijstRepository.getGroep(groepNaam)


        adapter = ExpenseLijstAdapter(expenselijst)
        binding.rvExpenseLijst.adapter = adapter
        binding.rvExpenseLijst.layoutManager = LinearLayoutManager(this.context)

        laadExpenses()

        binding.btnAddExpense.setOnClickListener{
            findNavController().navigate(R.id.action_expenseLijstFragment_to_addExpenseFragment)
        }
        return binding.root
    }

    private fun laadExpenses(){
        expenselijst.clear()
        expenselijst.addAll(groep.loadExpenses())
   }

   fun selecteerExpense(expense: Expense){
        findNavController().navigate(R.id.action_expenseLijstFragment_to_expenseDetailFragment, bundleOf(Expense.EXPENSE_ID to expense.id.toString()))
    }

    /*fun clearAllItems() {
        groeplijst.clear()
        expenselijst.clear()
        adapter.notifyDataSetChanged()
    }*/
}