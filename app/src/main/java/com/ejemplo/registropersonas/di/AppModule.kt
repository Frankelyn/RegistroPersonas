package com.ejemplo.registropersonas.di

import android.content.Context
import androidx.room.Room
import com.ejemplo.registropersonas.data.PersonasDao
import com.ejemplo.registropersonas.data.PersonasDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


        @Singleton
        @Provides
        fun ProvideTicketDb(@ApplicationContext context: Context): PersonasDb {
          val DATABASE_NAME = "PersonasDb"
            return Room.databaseBuilder(
                context,
                PersonasDb::class.java,
                DATABASE_NAME       )
                .fallbackToDestructiveMigration()
                .build()
        }

        @Provides
        fun ProvidePersonasDAO(personasDb: PersonasDb): PersonasDao {
            return personasDb.personasDao
        }

}