package com.example.android.easygobandprueba.mainactivity.starting.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.android.data.remote.ResultHandler
import com.example.android.data.repositories.EventsRepository
import com.example.android.easygobandprueba.commons.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StartingViewModel(
    private val repository: EventsRepository
): BaseViewModel() {


    fun startSearch(id: Int){
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO){
            when (val result = repository.getAndSaveEvents(id)) {
                is ResultHandler.Success -> {
                    //When successful API call
                    navigateToNextFragmentFromCoroutine(true)
                    Log.i("jaja", "False")
                }
                else -> {
                    //when error API call
                    setShowError(result)
                    Log.i("jaja", "False")
                    navigateToNextFragmentFromCoroutine(false)
                }
            }
            _isLoading.postValue(false)
        }
    }
}