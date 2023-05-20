package com.example.expensestracker.model


import kotlinx.serialization.Serializable

@Serializable
class Expense : java.io.Serializable {
    private var naam: String
    private var bedrag: Double
    private var id: Int = 0


    //private var tag: Tag
    private val imagePath: String?

    constructor(naam: String, bedrag: Double, imagePath: String?) {
        this.naam = naam
        this.bedrag = bedrag
        // this.tag = tag
        this.imagePath = imagePath
    }

    fun getNaam(): String {
        return naam
    }

    fun getBedrag(): Double {
        return bedrag
    }

    fun getId(): Int {
        return id
    }

    fun getImagePath(): String? {
        return imagePath
    }

    /*  fun getTag(): Tag{
          return tag
      }*/
    fun setId(id: Int) {
        this.id = id
    }


    companion object {
        val EXPENSE_ID = "ExpenseId"
    }
}
