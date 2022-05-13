package com.ejemplo.registropersonas.viewmodel

import androidx.lifecycle.*
import com.ejemplo.registropersonas.data.PersonasDao
import com.ejemplo.registropersonas.model.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


@HiltViewModel
class PersonaViewModel @Inject constructor(
    val personasDao: PersonasDao
) : ViewModel(){

    val personas : Flow<List<Person>>
        get() =  personasDao.GetLista()

    private val _guardado = MutableLiveData(false)
    val guardado: LiveData<Boolean> get() = _guardado

    fun guardar(persona: Person){
       viewModelScope.launch {
           personasDao.Insertar(persona)
           _guardado.value=true
       }
     }

}