package com.example.expensestracker.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.expensestracker.model.Expense
import com.example.expensestracker.model.Groep

@Dao
interface GroepLijstDao {
    @Query("SELECT * FROM Groep")
    fun query(): List<Groep>

    @Update
    fun update(items: List<Groep>)

    @Query("DELETE FROM Groep")
    fun deleteAll()

    @Insert
    fun insert(items: List<Groep>)

    @Insert
    fun insert(groep: Groep)


}