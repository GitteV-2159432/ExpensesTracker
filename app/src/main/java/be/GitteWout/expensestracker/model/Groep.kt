package be.GitteWout.expensestracker.model

import kotlinx.serialization.Serializable

@Serializable
class Groep : java.io.Serializable {
    private var naam: String
    private val expenses = arrayListOf<Expense>()
    private var id: Int = 0

    constructor(naam: String) {
        this.naam = naam
    }

    fun addExpense(uitgave: Expense) {
        expenses.add(uitgave)
    }

    fun loadExpenses(): ArrayList<Expense> {
        return expenses
    }

    fun getNaam(): String {
        return naam
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getTotal(): Double {
        var total: Double = 0.0
        for (e: Expense in expenses) {
            total += e.getBedrag()
        }
        return total
    }

    companion object {
        val GROEP_ID = "GroepId"
    }


}