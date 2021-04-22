package com.example.android.easygobandprueba.mainactivity.list.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android.data.models.EventDTO
import com.example.android.data.repositories.EventsRepository
import com.example.android.easygobandprueba.commons.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(
        private val repository: EventsRepository
) : BaseViewModel() {


    private var _eventListFiltered = MutableLiveData<List<EventDTO>>()
    val eventListFiltered: LiveData<List<EventDTO>>
        get() = _eventListFiltered


    fun filterEventListByName(str: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _eventListFiltered.postValue(repository.getEventsFilteredBySessionName("%$str%"))
        }
    }

    fun assignValueToEventListFiltered() {
        viewModelScope.launch(Dispatchers.IO) {
            _eventListFiltered.postValue(repository.getEvents())
        }
    }
}