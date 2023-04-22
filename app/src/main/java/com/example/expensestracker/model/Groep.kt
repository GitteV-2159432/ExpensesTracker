package com.example.expensestracker.model

import kotlinx.serialization.Serializable

@Serializable
data class Groep (val naam: String, val bedrag: Int, val expenses: List<Expense>, var id: Int = 0): java.io.Serializable{

    companion object {
        val GROEP_ID = "GroepId"
    }
}