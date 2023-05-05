package com.example.expensestracker.model

interface GroepLijstRepository {
    fun loadGroepen(): List<Groep>
    fun getGroep(naam: String?): Groep

    fun saveGroepen(Items: List<Groep>)
    fun saveGroep(groep: Groep)
    fun deleteGroep(groep: Groep)
    fun deleteAllGroepen()


}