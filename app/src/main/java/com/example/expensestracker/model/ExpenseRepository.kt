package com.example.expensestracker.model

import android.content.Context
import androidx.core.content.edit
import androidx.fragment.app.FragmentActivity
import com.example.expensestracker.R
import com.google.gson.*

interface ExpenseRepository {
    fun loadExpenses(): List<Expense>

    fun saveExpenses(Items: List<Expense>)
    fun saveExpenses(expense: Expenses)

    fun deleteExpense(expense: Expenses) //Moeten nog geimplementeerd worden
    fun deleteAllExpenses()
}