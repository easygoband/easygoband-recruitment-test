package com.example.krashlandocodingtest

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class ShowDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)

        val event = intent.getParcelableExtra<EventProvider>("event")

        val id = findViewById(R.id.DetailEventId) as TextView
        val accesGroupId = findViewById(R.id.DetailAccesGroupId) as TextView
        val accessGroupName = findViewById(R.id.DetailAccessGroupNamet) as TextView
        val totalUses = findViewById(R.id.DetailTotalUses) as TextView
        val structureDecode = findViewById(R.id.DetailStructureDecode) as TextView
        val name = findViewById(R.id.DetailName) as TextView
        val modified = findViewById(R.id.DetailModified) as TextView

        accesGroupId.setText(event?.accesGroupId.toString())
        accessGroupName.setText(event?.accessGroupName)
        totalUses.setText(event?.totalUses.toString())
        structureDecode.setText(event?.structureDecode.toString())
        name.setText(event?.name)
        modified.setText(event?.modified)
        id.setText(event?.id.toString())
    }
}