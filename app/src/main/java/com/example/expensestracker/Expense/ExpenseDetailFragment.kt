package com.example.expensestracker.Expense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expensestracker.MainActivity
import com.example.expensestracker.R
import com.example.expensestracker.databinding.FragmentExpensedetailBinding

class ExpenseDetailFragment: Fragment(R.layout.fragment_expensedetail) {

    private lateinit var binding: FragmentExpensedetailBinding
    private lateinit var main: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExpensedetailBinding.inflate(layoutInflater)
        main = activity as MainActivity

        return binding.root
    }
}