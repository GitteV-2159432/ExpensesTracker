package com.example.expensestracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Groep (
    @ColumnInfo(name = "naam")val naam: String,
    @ColumnInfo(name = "bedrag")val bedrag: Int,
    @PrimaryKey(autoGenerate = true) var id: Int = 0): java.io.Serializable{

        companion object {
            val GROEP_ID = "GameId"
        }
    }