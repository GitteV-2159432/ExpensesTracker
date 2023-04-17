package com.example.expensestracker.model

interface GroepLijstRepository {
    fun load(): List<Groep>
    fun save(groep: Groep)
    fun save(Items: List<Groep>)


}