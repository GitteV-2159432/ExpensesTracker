package be.GitteWout.expensestracker.model

import android.graphics.Bitmap

interface ImageRepository {
    fun saveImage(image: Bitmap, filename: String)
    fun loadImage(filename: String): Bitmap?
    fun deleteExpenseImage(filename: String)
}