package com.example.easygoband2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codinginflow.recyclerviewexample.ExampleAdapter
import com.example.easygoband.ExampleItem
import com.google.gson.GsonBuilder
import okhttp3.Call
import okhttp3.OkHttpClient
import java.io.IOException

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        val btnShowList = findViewById<Button>(R.id.btnShowList)

        btnShowList.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        if(com.example.easygoband.Network.isNetworkAvailable(this)){
            // solicitud JSON

            val credential = "Basic cJmAc71jah17sgqi1jqaksvaksda="
//            val client = OkHttpClient()
            val url = "https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1"
//            val request = okhttp3.Request.Builder().url(url).addHeader("Authorization", credential).build()
            val client = CallAPI.client(credential,url)

            client.newCall(CallAPI.request(credential,url)).enqueue(object: okhttp3.Callback{
                override fun onFailure(call: okhttp3.Call, e: IOException) {
                    println("No API response")
                    Toast.makeText(this@MainActivity, "Fail to get API response.", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                    var body = response?.body()?.string()

                    val gson = GsonBuilder().create()
                    val listadatos = gson.fromJson(body, itemsArray2::class.java)


                    runOnUiThread {
                        val exlist =  ArrayList<ExampleItem>()
                        for(i in 0 until listadatos.size){
                            val itm = ExampleItem(R.drawable.ic_baseline_keyboard_arrow_right_24,listadatos[i].name, listadatos[i].id.toString())
                            exlist += itm

                        }
                        val btnSearchID = findViewById<Button>(R.id.btnSearchID)
                        val intent3 = Intent(this@MainActivity,ThirdActivity::class.java)

                        btnSearchID.setOnClickListener {
                            val uID = findViewById<EditText>(R.id.etID).text.toString()
                            if (validateID(uID)) {
                                val userID = uID.toInt()
                                var userFound = false
                                for (i in 0 until listadatos.size) {
                                    if (userID == listadatos[i].id) {
                                        userFound = true
                                        intent3.putExtra("Error", false)

                                        intent3.putExtra("AccessGroupName", listadatos[i].access_group_name)
                                        intent3.putExtra("AccessGroupID", listadatos[i].access_group_id)
                                        intent3.putExtra("TotalUses", listadatos[i].total_uses)
                                        intent3.putExtra("Session", listadatos[i].sessions[0].name)
                                        intent3.putExtra("SessionID", listadatos[i].sessions[0].id)
                                        intent3.putExtra("EventID", listadatos[i].event_id)
                                        intent3.putExtra("StructureDecode", listadatos[i].structure_decode)
                                        intent3.putExtra("Name", listadatos[i].name)
                                        intent3.putExtra("ID", listadatos[i].id)
                                        intent3.putExtra("BasicProductID", listadatos[i].basic_product_id)
                                        startActivity(intent3)

                                    }
                                }
                                if (!userFound) {
                                    // User not found
                                    intent3.putExtra("Error", true)
                                    startActivity(intent3)
                                }


                            }else{
                                Toast.makeText(this@MainActivity, "User ID not valid", Toast.LENGTH_SHORT).show()
                            }
                        }


                    }

                }


            })

        } else{
            //mostrar error: no hay red
            Toast.makeText(this, "No estás conectado a la red.", Toast.LENGTH_LONG).show()
        }


    }


}


private fun validateID(uID: String): Boolean {
    return if (uID.isNullOrEmpty()) false else uID.all { Character.isDigit(it) }
}