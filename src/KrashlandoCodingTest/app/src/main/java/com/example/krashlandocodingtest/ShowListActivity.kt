package com.example.krashlandocodingtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShowListActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)

        val eventProviders = intent.getParcelableArrayExtra("events")?.map {
            it as EventProvider
        }?.toTypedArray()

        val eventAdapter = eventProviders?.let { EventAdapter(it) }

        recyclerView = findViewById(R.id.ShowListRecyclerView)

        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL

        recyclerView.setLayoutManager(llm)
        recyclerView.setHasFixedSize(false)

        recyclerView.adapter = eventAdapter
    }

}