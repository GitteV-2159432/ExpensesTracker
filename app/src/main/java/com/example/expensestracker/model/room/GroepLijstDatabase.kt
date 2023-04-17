package com.example.expensestracker.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.expensestracker.model.Groep

@Database(entities = arrayOf(Groep::class), version = 1)
abstract class GroepLijstDatabase: RoomDatabase() {
    abstract fun groepLijstDao(): GroepLijstDao
}