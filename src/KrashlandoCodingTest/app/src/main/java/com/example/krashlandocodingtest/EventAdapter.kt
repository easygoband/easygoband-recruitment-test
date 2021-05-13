package com.example.krashlandocodingtest

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class EventAdapter(private val events: Array<EventProvider>) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView
        var eventId: TextView
        var modified: TextView
        var accessGroupName: TextView

        init {
            name = view.findViewById(R.id.EventItemName)
            eventId = view.findViewById(R.id.EventItemId)
            modified = view.findViewById(R.id.EventItemModified)
            accessGroupName = view.findViewById((R.id.AccessGroupName))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event_item_element, parent, false)

        return EventViewHolder(view)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]

        holder.eventId.setText(event.id.toString())
        holder.name.setText(event.name)
        holder.modified.setText((event.modified))
        holder.accessGroupName.setText(event.accessGroupName)

        var bgColor = Color.parseColor( if(position % 2 == 0) "#CDFFF9" else "#ffffff")
        holder.itemView.setBackgroundColor(bgColor)

        holder.itemView.setOnClickListener { v ->
            val context= v.context
            val intent = Intent(context, ShowDetail::class.java)

            val data: Bundle = Bundle()
            data.putParcelable("event", event)

            intent.putExtras(data)

            startActivity(context, intent, null)
        }
    }
}
