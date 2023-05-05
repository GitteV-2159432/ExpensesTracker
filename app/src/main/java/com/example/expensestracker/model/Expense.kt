package com.example.expensestracker.model


import kotlinx.serialization.Serializable

@Serializable
data class Expense(val naam: String, val bedrag: Double, var id: Int = 0): java.io.Serializable{
    companion object {
        val EXPENSE_ID = "ExpenseId"
    }
}