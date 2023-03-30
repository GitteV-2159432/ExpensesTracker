package com.example.expensestracker.model

@kotlinx.serialization.Serializable
data class Groep (val naam: String, val bedrag: Int) : java.io.Serializable{}