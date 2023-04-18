package com.example.expensestracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.expensestracker.databinding.FragmentAddexpenseBinding

class AddExpenseFragment: Fragment(R.layout.fragment_addexpense)  {

    private lateinit var binding: FragmentAddexpenseBinding
    private lateinit var main: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddexpenseBinding.inflate(layoutInflater)
        main = activity as MainActivity

        binding.btnAddExpense.setOnClickListener{
            findNavController().navigate(R.id.action_addExpenseFragment_to_expenseLijstFragment)
        }
        return binding.root
    }

}