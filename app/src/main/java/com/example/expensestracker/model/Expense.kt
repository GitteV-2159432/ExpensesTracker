package com.example.expensestracker.model

import java.util.Date
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Expense (
    @ColumnInfo(name = "naam")val naam: String,
    @ColumnInfo(name = "bedrag")val bedrag: Int,
    @ColumnInfo(name = "dag") val dag: Int,
    @ColumnInfo(name = "maand")val maand: Int,
    @ColumnInfo(name = "jaar")val jaar: Int,
    @PrimaryKey(autoGenerate = true) var id: Int = 0): java.io.Serializable{

    companion object {
        val EXPENSE_ID = "GameId"
    }
    }