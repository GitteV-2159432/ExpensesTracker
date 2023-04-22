package com.example.expensestracker.model

import android.content.Context
import androidx.core.content.edit
import androidx.fragment.app.FragmentActivity
import com.example.expensestracker.R

import com.google.gson.*

class GroepLijstPreferencesRepository(val activity: FragmentActivity): GroepLijstRepository {
    override fun saveGroep(groep: Groep) {
        val gson = Gson()
        val groepGson = gson.toJson(groep)
        val sharedPref = activity.getSharedPreferences(activity.getString(R.string.groep_data),Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            putString(groep.naam, groepGson)
            apply()
        }
    }

    override fun saveGroepen(Items: List<Groep>) {
        Items.forEach{saveGroep(it)}
    }

    override fun loadGroepen(): List<Groep> {
        val sharedPref = activity.getSharedPreferences(activity.getString(R.string.groep_data),Context.MODE_PRIVATE)
        val groepMap = sharedPref.all
        val groepLijst = mutableListOf<Groep>()
        for(groepData in groepMap.entries){
            val gson = Gson()
            val groep = gson.fromJson(groepData.value as String, Groep::class.java)
            groepLijst.add(groep)
        }
        return groepLijst
    }

    override fun deleteGroep(groep: Groep) {
        val sharedPref = activity.getSharedPreferences(activity.getString(R.string.groep_data), Context.MODE_PRIVATE)
        sharedPref.edit{
            remove(groep.naam)
            commit()
        }
    }

    override fun deleteAllGroepen() {
        val sharedPref = activity.getSharedPreferences(activity.getString(R.string.groep_data),Context.MODE_PRIVATE)
        sharedPref.edit{
            clear()
            commit()
        }
    }
}
