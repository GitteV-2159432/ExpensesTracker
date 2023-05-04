package com.example.expensestracker.model

import android.content.Context
import androidx.core.content.edit
import androidx.fragment.app.FragmentActivity
import com.example.expensestracker.R

import com.google.gson.*
interface GroepLijstRepository {
    fun loadGroepen(): List<Groep>

    fun saveGroepen(Items: List<Groep>)
    fun saveGroep(groep: Groep)
    fun deleteGroep(groep: Groep)
    fun deleteAllGroepen()


}