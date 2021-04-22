package com.example.android.easygobandprueba.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.data.models.EventDTO
import com.example.android.easygobandprueba.commons.BaseViewModel

class SharedEventVM : BaseViewModel(){

    private var _event = MutableLiveData<EventDTO>()
    val event: LiveData<EventDTO>
        get() = _event

    fun setEvent(event: EventDTO) {
        _event.value = event
    }
}