package be.GitteWout.expensestracker.model


import android.database.DatabaseUtils
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.util.Date

@Serializable
class Expense : java.io.Serializable {
    private var naam: String
    private var bedrag: Double
    private var id: Int = 0
   @Contextual private var datum: String
    private val imagePath: String?

    constructor(naam: String, bedrag: Double, imagePath: String?, datum: String) {
        this.naam = naam
        this.bedrag = bedrag
        this.imagePath = imagePath
        this.datum = datum
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

      fun getDatum(): String{
          return datum
      }
    fun setId(id: Int) {
        this.id = id
    }


    companion object {
        val EXPENSE_ID = "ExpenseId"
    }
}
