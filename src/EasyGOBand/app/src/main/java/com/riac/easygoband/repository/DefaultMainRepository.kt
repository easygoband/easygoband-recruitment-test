package com.riac.easygoband.repository

import com.riac.easygoband.api.DataAPI
import com.riac.easygoband.models.APIResponse
import com.riac.easygoband.util.Constants.Companion.BASE_URL_LS
import com.riac.easygoband.util.Resource
import java.lang.Exception
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: DataAPI
) : MainRepository {
    override suspend fun getData(id: Int): Resource<APIResponse> {
        return try {
            val response = api.getData(id)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }

        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error ocurred")
        }
    }

    override suspend fun getDataLS(): Resource<APIResponse> {
        return try {
            val response = api.getDataLS(BASE_URL_LS)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error ocurred")
        }
    }

}