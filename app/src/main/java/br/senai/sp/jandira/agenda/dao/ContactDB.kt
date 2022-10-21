package br.senai.sp.jandira.agenda.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.agenda.model.Contact

// Classe que acessa o banco de dados
@Database(entities = [Contact::class], version = 1)
abstract class ContactDB: RoomDatabase() {

    abstract fun contactDAO(): ContactDAO

    companion object {
        private lateinit var instance: ContactDB

        fun getDataBase(context: Context): ContactDB {
            // '::' - forçar a incialização da variável
            if(!::instance.isInitialized) {
                // Criação de apenas uma instância
                instance = Room.databaseBuilder(context,
                                                ContactDB::class.java,
                                                "db_agenda").allowMainThreadQueries().build()

                return instance
            }
            return instance
        }
    }
}