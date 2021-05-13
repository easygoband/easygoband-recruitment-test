package com.example.krashlandocodingtest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

const val EXTRA_MESSAGE = "MAIN_ACTIVITY"

class MainActivity : AppCompatActivity() {

    private val httpClient = OkHttpClient()
    private lateinit var msgError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById(R.id.MainEditTextNumberId) as EditText
        msgError = findViewById(R.id.MainTextViewErrorMsg) as TextView
        val searchBtn = findViewById(R.id.MainBTNSearch) as Button

        searchBtn.setOnClickListener {

            try {
                val eventId = input.text.toString()

                val url: String = getString(R.string.url) + eventId

                val request = Request.Builder()
                        .url(url)
                        .addHeader("Authorization", "Basic cJmAc71jah17sgqi1jqaksvaksda=")
                        .build()

                httpClient.newCall(request).enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        e.printStackTrace()
                    }

                    override fun onResponse(call: Call, response: Response) {
                        response.use {
                            if (!it.isSuccessful && it.code() != 404) {
                                throw IOException(it.message())
                            }

                            val body = it.body()?.string()
                            val gson = GsonBuilder().create()

                            if (it.isSuccessful) {
                                val events = gson.fromJson(body, Array<EventProvider>::class.java)
                                startShowListActivity(events)
                            } else {
                                val error = gson.fromJson(body, ErrorMessage::class.java)
                                runOnUiThread {
                                    msgError.setText(error.message)
                                }
                            }

                        }
                    }
                })

            } catch (exception: IOException) {
                runOnUiThread {
                    msgError.setText(exception.message ?: "unhandled error")
                }
            }
        }
    }

    private fun updateUI(msg: String?) {

    }

    private fun startShowListActivity(events: Array<EventProvider>) {

        val intent = Intent(this, ShowListActivity::class.java)

        val data: Bundle = Bundle()
        data.putParcelableArray("events", events)

        intent.putExtras(data)

        startActivity(intent)
    }
}