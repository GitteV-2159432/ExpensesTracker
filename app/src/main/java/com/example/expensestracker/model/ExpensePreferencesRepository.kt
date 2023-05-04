package com.example.expensestracker.model

import android.content.Context
import androidx.core.content.edit
import androidx.fragment.app.FragmentActivity
import com.example.expensestracker.R
import com.google.gson.*

class ExpensePreferencesRepository(val activity: FragmentActivity): GroepLijstRepository {

    override fun saveExpense(expense: Expense) {
        val gson = Gson()
        val groepGson = gson.toJson(expense)
        val sharedPref = activity.getSharedPreferences(activity.getString(R.string.expense_data),Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            putString(expense.naam, expenseGson)
            apply()
        }
    }
}