package com.example.expensestracker.model.room

import android.content.Context
import androidx.room.Room
import com.example.expensestracker.model.Groep
import com.example.expensestracker.model.GroepLijstRepository

class GroepLijstRoomRepository(appContext: Context): GroepLijstRepository {
    private val db: GroepLijstDatabase
    private val dao: GroepLijstDao

    init {
        db = Room.databaseBuilder(appContext, GroepLijstDatabase::class.java, "groep-db").allowMainThreadQueries().build()
        dao = db.groepLijstDao()
    }

    override fun load(): List<Groep> = dao.query()

    override fun save(groep: Groep) {
        db.runInTransaction{
            dao.insert(groep)
        }
    }

    override fun save(items: List<Groep>) {
        db.runInTransaction{
            dao.deleteAll()
            dao.insert(items)
        }
    }
}