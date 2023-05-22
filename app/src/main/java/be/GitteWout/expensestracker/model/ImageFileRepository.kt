package be.GitteWout.expensestracker.model

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.FileNotFoundException

class ImageFileRepository(val context: Context) : ImageRepository {
    override fun saveImage(image: Bitmap, filename: String) {
        context.openFileOutput(filename.lowercase(), Context.MODE_PRIVATE).use {
            image.compress(Bitmap.CompressFormat.JPEG, 80, it)
            it.flush()
        }
    }

    override fun loadImage(filename: String): Bitmap? {
        try {
            context.openFileInput(filename.lowercase()).use {
                return BitmapFactory.decodeStream(it)
            }
        } catch (ex: FileNotFoundException) {
            return null
        }
    }

    override fun deleteExpenseImage(filename: String) {
        context.deleteFile(filename.lowercase())
    }
}