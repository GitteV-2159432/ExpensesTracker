package com.example.expensestracker.model.file

import android.content.Context
import com.example.expensestracker.model.Expense
import com.example.expensestracker.model.ExpenseRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.*

class ExpenseFileRepository(val context: Context) : ExpensesRepository {

    override fun loadExpenses(): List<Expense> {
        val where: File = context.getFilesDir()
        val fileName = "Expenses.txt"
        val realFileName = where.getAbsolutePath()+"/"+fileName
        val gson = Gson()
        val ExpenseLijstType = object: TypeToken<List<Expense>>() {}.type
        try {
            val lijst = gson.fromJson<List<Expense>>(FileReader(realFileName), ExpenseLijstType)
            return lijst
        }
        catch (e: Exception){
            return emptyList()
        }
    }

    override fun saveExpenses(items: List<Expense>) {
        val fileName = "Expenses.txt"
        val fos: FileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)

        val gson = Gson()
        val output = gson.toJson(items)
        fos.write(output.toByteArray())
        fos.close()
    }

    override fun saveExpense(expense: Expenses) {
        val fileName = "Expenses.txt"
        val fos: FileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)
        val gson = Gson()
        val output = gson.toJson(groep)
        fos.write(output.toByteArray())
        fos.close()
    }

    override fun deleteAllExpenses() {
        TODO("Not yet implemented")
    }

    override fun deleteExpense(expense: Expense) {//TODO deleteExpenses implementeren
        TODO("Not yet implemented")
    }
}