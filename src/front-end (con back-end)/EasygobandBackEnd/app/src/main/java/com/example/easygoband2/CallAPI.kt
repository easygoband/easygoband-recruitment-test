package com.example.easygoband2

import android.widget.Toast
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class CallAPI (url: String){

    companion object{
        fun client(url: String): OkHttpClient {
            val client = OkHttpClient()
            return client
        }
        fun request(url: String): Request {
            val request = okhttp3.Request.Builder().url(url).addHeader("Accept", "application/json").build()
            return request
        }
    }


}