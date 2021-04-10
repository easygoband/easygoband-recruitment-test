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

    private lateinit var uID: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnSearchID = findViewById<Button>(R.id.btnSearchID)
        val btnShowList = findViewById<Button>(R.id.btnShowList)

        btnShowList.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }


        btnSearchID.setOnClickListener {

            val uID = findViewById<EditText>(R.id.etID).text.toString()
            println("http://10.0.2.2:3000/" + uID)
            if(com.example.easygoband.Network.isNetworkAvailable(this)){
                // solicitud JSON

                val url = "http://10.0.2.2:3000/" + uID
                val client = CallAPI.client(url)

                client.newCall(CallAPI.request(url)).enqueue(object: okhttp3.Callback{
                    override fun onFailure(call: okhttp3.Call, e: IOException) {
                        println("No API response")

                    }

                    override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                        val body = response.body?.string()

                        if (body?.compareTo("User ID not found") == 0){
                            Toast.makeText(this@MainActivity, "User ID not found", Toast.LENGTH_SHORT).show()
                        }else{
                            val gson = GsonBuilder().create()
                            val listadatos = gson.fromJson(body, itemsArray2::class.java)

                            runOnUiThread {

                                val intent3 = Intent(this@MainActivity,ThirdActivity::class.java)

                                    if (validateID(uID)) {

                                        val userID = uID.toInt()
                                        var userFound = false
//                                        for (i in 0 until listadatos.size) {
                                            if (userID == listadatos[0].id) {
                                                userFound = true
                                                intent3.putExtra("Error", false)

                                                intent3.putExtra("AccessGroupName", listadatos[0].access_group_name)
                                                intent3.putExtra("AccessGroupID", listadatos[0].access_group_id)
                                                intent3.putExtra("TotalUses", listadatos[0].total_uses)
                                                intent3.putExtra("Session", listadatos[0].sessions[0].name)
                                                intent3.putExtra("SessionID", listadatos[0].sessions[0].id)
                                                intent3.putExtra("EventID", listadatos[0].event_id)
                                                intent3.putExtra("StructureDecode", listadatos[0].structure_decode)
                                                intent3.putExtra("Name", listadatos[0].name)
                                                intent3.putExtra("ID", listadatos[0].id)
                                                intent3.putExtra("BasicProductID", listadatos[0].basic_product_id)
                                                startActivity(intent3)

                                            }
//                                        }
                                        if (!userFound) {
                                            // User not found
                                            intent3.putExtra("Error", true)
                                            startActivity(intent3)
                                        }


                                    }else{
                                        Toast.makeText(this@MainActivity, "User ID not valid", Toast.LENGTH_SHORT).show()
                                    }
//                                }


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

    }




private fun validateID(uID: String): Boolean {
    return if (uID.isNullOrEmpty()) false else uID.all { Character.isDigit(it) }
}