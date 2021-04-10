package com.example.easygoband2

import com.android.volley.Network
import com.example.easygoband.ExampleItem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.codinginflow.recyclerviewexample.ExampleAdapter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.net.ResponseCache
import javax.security.auth.callback.Callback



class SecondActivity : AppCompatActivity(), ExampleAdapter.OnItemClickListener {

    private lateinit var listadatoss: Array<Datos2>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        if(com.example.easygoband.Network.isNetworkAvailable(this)){
            // solicitud JSON
            // Toast.makeText(this, "hay red!", Toast.LENGTH_LONG).show()
            runOnUiThread {
            val url = "http://10.0.2.2:3000/all"
            val client = CallAPI.client(url)

            client.newCall(CallAPI.request(url)).enqueue(object: okhttp3.Callback{
                override fun onFailure(call: okhttp3.Call, e: IOException) {
                    println("No API response")
                }

                override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                    var body = response?.body?.string()

                    val gson = GsonBuilder().create()
                    listadatoss = gson.fromJson(body, itemsArray2::class.java)


                        val exlist =  ArrayList<ExampleItem>()
                        for(i in 0 until listadatoss.size){
                            val itm = ExampleItem(R.drawable.ic_baseline_keyboard_arrow_right_24,listadatoss[i].name, listadatoss[i].id.toString())
                            exlist += itm

                        }
                        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
                        recycler_view.adapter = ExampleAdapter(exlist,this@SecondActivity)
                        recycler_view.layoutManager = LinearLayoutManager(this@SecondActivity)
                        recycler_view.setHasFixedSize(true)

                    }

                })


            }


        } else{
        //mostrar error: no hay red
        Toast.makeText(this, "No estás conectado a la red.", Toast.LENGTH_LONG).show()
        }


    }

    override fun onItemClick(position: Int) {
//        Toast.makeText(this, "Funciona $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = listadatoss[position]

        val intent4 = Intent(this@SecondActivity,ThirdActivity::class.java)


        intent4.putExtra("Error", false)

        intent4.putExtra("AccessGroupName", listadatoss[position].access_group_name)
        intent4.putExtra("AccessGroupID", listadatoss[position].access_group_id)
        intent4.putExtra("TotalUses", listadatoss[position].total_uses)
        intent4.putExtra("Session", listadatoss[position].sessions[0].name)
        intent4.putExtra("SessionID", listadatoss[position].sessions[0].id)
        intent4.putExtra("EventID", listadatoss[position].event_id)
        intent4.putExtra("StructureDecode", listadatoss[position].structure_decode)
        intent4.putExtra("Name", listadatoss[position].name)
        intent4.putExtra("ID", listadatoss[position].id)
        intent4.putExtra("BasicProductID", listadatoss[position].basic_product_id)
        startActivity(intent4)

    }


}
