package com.example.expensestracker.model

import android.content.Context
import com.example.expensestracker.model.room.GroepLijstRoomRepository

interface GroepLijstRepository {
    fun load(): List<Groep>
    fun save(groep: Groep)
    fun save(Items: List<Groep>)
}