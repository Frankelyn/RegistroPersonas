package com.ejemplo.registropersonas.data

import androidx.room.*
import com.ejemplo.registropersonas.model.Person
import kotlinx.coroutines.flow.Flow


@Dao
interface PersonasDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(persona: Person)

    @Delete
    suspend fun Eliminar(persona: Person)


    @Query("""
        SELECT * 
        FROM Personas
        WHERE personaId=:personaId        
    """)
    fun Buscar(personaId: Int): Flow<Person>

    @Query("""
        SELECT * 
        FROM Personas
        ORDER BY personaId    
    """)
    fun GetLista(): Flow<List<Person>>

}