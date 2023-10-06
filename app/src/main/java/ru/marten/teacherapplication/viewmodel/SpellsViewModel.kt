package ru.marten.teacherapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.marten.teacherapplication.data.ClientOkHttp

class SpellsViewModel: ViewModel() {

    val spellsData = MutableLiveData<List<String>>()

    fun fetchSpells() {
        viewModelScope.launch(Dispatchers.IO) {
            spellsData.postValue( ClientOkHttp.harryPotterApi.getSpells(SPELL_TYPE)
                    .map { it.incantation ?: it.name }
            )
        }
    }

    companion object {
        private const val SPELL_TYPE = "Curse"
    }
}