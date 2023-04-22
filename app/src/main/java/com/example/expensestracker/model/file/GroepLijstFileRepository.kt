package com.example.expensestracker.model.file

import android.content.Context
import com.example.expensestracker.model.Groep
import com.example.expensestracker.model.GroepLijstRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.*

class GroepLijstFileRepository(val context: Context) : GroepLijstRepository {

    override fun loadGroepen(): List<Groep> {
        val where: File = context.getFilesDir()
        val fileName = "GroepLijst.txt"
        val realFileName = where.getAbsolutePath()+"/"+fileName
        val gson = Gson()
        val groepLijstType = object: TypeToken<List<Groep>>() {}.type
        try {
            val lijst = gson.fromJson<List<Groep>>(FileReader(realFileName), groepLijstType)
            return lijst
        }
        catch (e: Exception){
            return emptyList()
        }
    }

    override fun saveGroepen(items: List<Groep>) {
        val fileName = "GroepLijst.txt"
        val fos: FileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)

        val gson = Gson()
        val output = gson.toJson(items)
        fos.write(output.toByteArray())
        fos.close()
    }

    override fun saveGroep(groep: Groep) {
        val fileName = "GroepLijst.txt"
        val fos: FileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)
        val gson = Gson()
        val output = gson.toJson(groep)
        fos.write(output.toByteArray())
        fos.close()
    }

    override fun deleteAllGroepen() {
        TODO("Not yet implemented")
    }

    override fun deleteGroep(groep: Groep) {
        TODO("Not yet implemented")
    }
}


