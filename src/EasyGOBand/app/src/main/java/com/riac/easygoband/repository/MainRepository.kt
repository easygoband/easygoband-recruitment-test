package com.riac.easygoband.repository

import com.riac.easygoband.models.APIResponse
import com.riac.easygoband.util.Resource

interface MainRepository {
    suspend fun getData(id: Int): Resource<APIResponse>
    suspend fun getDataLS(): Resource<APIResponse>
}