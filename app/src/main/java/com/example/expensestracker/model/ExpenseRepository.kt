package com.example.expensestracker.model

interface ExpenseRepository {
    fun loadExpenses(): List<Expense>
    fun getExpense(naam: String?): Expense

    fun saveExpenses(Items: List<Expense>)
    fun saveExpense(expense: Expense)
    fun deleteExpense(expense: Expense)
    fun deleteAllExpenses()


}