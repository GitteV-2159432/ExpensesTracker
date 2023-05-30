package be.GitteWout.expensestracker

import be.GitteWout.expensestracker.model.Expense
import be.GitteWout.expensestracker.model.ExpenseFilter
import org.junit.Test

import org.junit.Assert.*

class ExpenseFilterTest {
    @Test
    fun filterExpensesShouldReturnTheSearchedExpenses() {
        val tanken = Expense("Tanken", 57.95, null, "")
        val winkelen = Expense("Winkelen", 23.99, null, "")
        val kapper =  Expense("Kapper", 43.00, null, "")
        val expensesList = listOf(tanken, winkelen, kapper)

        val filter = ExpenseFilter()

        val filterExpense1 = filter.filterExpenses(expensesList, "a")
        assertTrue(filterExpense1.contains(tanken))
        assertTrue(filterExpense1.contains(kapper))

        val filterExpense2 = filter.filterExpenses(expensesList, "i")
        assertTrue(filterExpense2.contains(winkelen))

        val filterExpense3 = filter.filterExpenses(expensesList, "k")
        assertTrue(filterExpense3.contains(kapper) && filterExpense3.contains(winkelen) && filterExpense3.contains(tanken))

        val filterExpense4 = filter.filterExpenses(expensesList, "kap")
        assertTrue(filterExpense4.contains(kapper))

    }
}