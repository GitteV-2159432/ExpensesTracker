package be.GitteWout.expensestracker.model

import android.content.Context
import androidx.core.content.edit
import androidx.fragment.app.FragmentActivity
import be.GitteWout.expensestracker.R
import com.google.gson.Gson
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ExpensePreferencesRepository(val activity: FragmentActivity) : ExpenseRepository {
    override fun saveExpense(expense: Expense) {
        val gson = Gson()
        val expenseGson = gson.toJson(expense)
        val sharedPref = activity.getSharedPreferences(
            activity.getString(R.string.expense_data),
            Context.MODE_PRIVATE
        )
        with(sharedPref.edit()) {
            putString(expense.getNaam(), expenseGson)
            apply()
        }
    }

    override fun saveExpenses(Items: List<Expense>) {
        Items.forEach { saveExpense(it) }
    }

    override fun loadExpenses(): List<Expense> {
        val sharedPref = activity.getSharedPreferences(
            activity.getString(R.string.expense_data),
            Context.MODE_PRIVATE
        )
        val expenseMap = sharedPref.all
        val expenseLijst = mutableListOf<Expense>()
        for (expenseData in expenseMap.entries) {
            val gson = Gson()
            val expense = gson.fromJson(expenseData.value as String, Expense::class.java)
            expenseLijst.add(expense)
        }
        return expenseLijst
    }

    override fun getExpense(naam: String?): Expense {
        val sharedPref = activity.getSharedPreferences(
            activity.getString(R.string.expense_data),
            Context.MODE_PRIVATE
        )
        val expenseJSON = sharedPref.getString(naam, "NOTHING")
        if (expenseJSON.equals("NOTHING")) {
            System.out.println("expense " + naam + " niet gevonden")
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            val date = LocalDate.now().format(formatter)
            return Expense("NOTHING", 0.0, null, date)
        }
        val expense = Gson().fromJson(expenseJSON, Expense::class.java)
        return expense
    }


    override fun deleteExpense(expense: Expense) {
        val sharedPref = activity.getSharedPreferences(
            activity.getString(R.string.expense_data),
            Context.MODE_PRIVATE
        )
        sharedPref.edit {
            remove(expense.getNaam())
            commit()
        }
    }

    override fun deleteAllExpenses() {
        val sharedPref = activity.getSharedPreferences(
            activity.getString(R.string.expense_data),
            Context.MODE_PRIVATE
        )
        sharedPref.edit {
            clear()
            commit()
        }
    }
}
