package com.riac.easygoband.api

import com.riac.easygoband.models.APIResponse
import com.riac.easygoband.util.Constants.Companion.AUTH
import com.riac.easygoband.util.Constants.Companion.AUTH_LS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Url


interface DataAPI {
    @Headers(AUTH)
    @GET("dev/providers/{id}")
    suspend fun getData(
        @Path("id") id: Int,
        ): Response<APIResponse>

    @Headers(AUTH_LS)
    @GET
    suspend fun getDataLS(
        @Url url: String,
    ): Response<APIResponse>

}