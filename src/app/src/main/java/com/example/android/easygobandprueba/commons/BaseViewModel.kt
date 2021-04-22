package com.example.android.easygobandprueba.commons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.data.remote.ResultHandler
import com.example.android.easygobandprueba.utils.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {


    protected var _showError = SingleLiveEvent<String>()
    val showError: LiveData<String>
        get() = _showError

    protected var _navigate = SingleLiveEvent<Boolean>()
    val navigate: LiveData<Boolean>
        get() = _navigate


    protected var _isLoading = SingleLiveEvent<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun navigateToNextFragment(bool: Boolean){
        _navigate.value = bool
    }

    suspend fun navigateToNextFragmentFromCoroutine(bool: Boolean){
        _navigate.postValue(bool)
    }


    //Errors from API call
    suspend fun setShowError(resultHandler: ResultHandler<Any>){
        when (resultHandler){
            is ResultHandler.NetworkError -> {
                _showError.postValue(Constants.NETWORK_ERROR)
            }
            is ResultHandler.HttpError -> {
                _showError.postValue("${resultHandler.code!!}")
            }
            is ResultHandler.GenericError -> {
                _showError.postValue(resultHandler.message!!)
            }
            else -> {
                _showError.postValue(Constants.NETWORK_ERROR)
            }
        }
    }

    fun setShowError(str: String){
        _showError.value = str
    }
}