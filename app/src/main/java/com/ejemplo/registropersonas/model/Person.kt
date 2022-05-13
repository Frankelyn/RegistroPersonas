package com.ejemplo.registropersonas.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Personas")
data class Person (
    @PrimaryKey(autoGenerate = true)
    val PersonaId: Int,
    val Nombres: String,
    val Email: String,
    val OcupacionId: Int,
    val Salario: Float
)