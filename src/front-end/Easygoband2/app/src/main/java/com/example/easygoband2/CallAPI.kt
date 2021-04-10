package com.example.easygoband2

import android.widget.Toast
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class CallAPI (header: String, url: String){

    companion object{
        fun client(header: String, url: String): OkHttpClient {
            val client = OkHttpClient()
            return client
        }
        fun request(header: String, url: String): Request {
            val request = okhttp3.Request.Builder().url(url).addHeader("Authorization", header).build()
            return request
        }
    }


}