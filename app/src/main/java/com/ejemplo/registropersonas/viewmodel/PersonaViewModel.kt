package com.ejemplo.registropersonas.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.ejemplo.registropersonas.data.PersonasDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import com.ejemplo.registropersonas.model.Persona
import kotlinx.coroutines.launch

@HiltViewModel
class PersonaViewModel @Inject constructor(
    val personasDao: PersonasDao
) : ViewModel(){

    private val _guardado = MutableLiveData(false)
    val guardado: LiveData<Boolean> get() = _guardado

    fun guardar(persona: Persona){
       viewModelScope.launch {
           personasDao.Insertar(persona)
           _guardado.value=true
       }
     }

}