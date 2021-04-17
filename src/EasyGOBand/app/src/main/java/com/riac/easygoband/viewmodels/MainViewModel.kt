package com.riac.easygoband.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.riac.easygoband.models.APIResponse
import com.riac.easygoband.repository.MainRepository
import com.riac.easygoband.util.DispatcherProvider
import com.riac.easygoband.util.Resource
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val repository: MainRepository,
    private val dispatcher: DispatcherProvider
) : ViewModel() {

    var retrievedData: MutableLiveData<Resource<APIResponse>> = MutableLiveData()
    private val serverSelection: MutableLiveData<Int> = MutableLiveData()
    private val requestedId: MutableLiveData<Int> = MutableLiveData()

    fun requestData() {
        viewModelScope.launch(dispatcher.io) {
            retrievedData.postValue(Resource.Loading())
            val response: Resource<APIResponse> = if (serverSelection.value == 1) {
                repository.getDataLS()
            } else {
                repository.getData(requestedId.value!!)
            }
            retrievedData.postValue(handleRetrievingData(response))
        }
    }

    fun setRequestId(id: Int) {
        requestedId.value = id
    }

    fun setServerSelection(id: Int) {
        serverSelection.value = id
    }

    private fun handleRetrievingData(apiResponse: Resource<APIResponse>): Resource<APIResponse> =
        if (apiResponse.data == null) {
            Resource.Error(apiResponse.message!!)
        } else {
            Resource.Success(apiResponse.data)
        }

}