package com.ejemplo.registropersonas.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ejemplo.registropersonas.model.Person

@Database(
    entities = [Person::class],
    version = 1
)
abstract class PersonasDb: RoomDatabase() {
    abstract  val personasDao: PersonasDao

   /* companion object {

        @Volatile private var instance: PersonasDb? = null

        private fun buildDataBase(context: Context): PersonasDb {
            return Room.databaseBuilder(
                context.applicationContext,
                PersonasDb::class.java,
                DATABASE_NAME
            ).build()
        }

        fun getInstance(context: Context): PersonasDb {
            return instance ?: synchronized(this) {
                instance ?: buildDataBase(context).also { instance = it }
            }
        }
    }*/

}