package com.example.easygoband2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)


        val tvuserID = findViewById<TextView>(R.id.tvUserIDD)
    //Get data from intent3
        val error = intent.getBooleanExtra("Error", true)

        if (!error){
            val accessGroupName = intent.getStringExtra("AccessGroupName")
            val accessGroupID = intent.getIntExtra("AccessGroupID",0)
            val totalUses = intent.getIntExtra("TotalUses",0)
            val sessionName: String? = intent.getStringExtra("Sesssion") // null?
            val sessionID = intent.getIntExtra("SessionID",0)
            val eventID = intent.getIntExtra("EventID",0)
            val structureDecode = intent.getBooleanExtra("StructureDecode", true).toString()
            val name = intent.getStringExtra("Name")
            val id = intent.getIntExtra("ID",0)
            val basicProductID = intent.getIntExtra("BasicProductID",0)

            tvuserID.text = getString(R.string.userdata, name, id, accessGroupName, accessGroupID, totalUses, sessionName, sessionID, eventID,
            structureDecode,basicProductID)

        }else{
            tvuserID.text = getString(R.string.userNotFound)
        }


    }
}
