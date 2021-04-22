package com.example.android.easygobandprueba.mainactivity.list.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.data.models.EventDTO
import com.example.android.easygobandprueba.commons.fromSessionsToString
import com.example.android.easygobandprueba.databinding.ItemEventBinding

class AdapterEventList(private var mValues: List<EventDTO>?,
                       private val cellClickListener: CellClickListener
) : RecyclerView.Adapter<AdapterEventList.ViewHolder>() {

    private lateinit var binding: ItemEventBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterEventList.ViewHolder {
        binding = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    //sets value to view objects
    override fun onBindViewHolder(holder: AdapterEventList.ViewHolder, position: Int) {
        mValues?.let {

            holder.tvName.text = "Name: ${it[position].name}"
            holder.tvId.text = "ID: ${it[position].id}"
            val sessions = fromSessionsToString(it[position].sessions)
            holder.tvSessionList.text = "Sessions: $sessions"

            holder.itemView.setOnClickListener { _ ->
                cellClickListener.onCellClickListener(it[position])
            }
        } ?: clearList() //in case mValues is null, it provides an empty list
    }

    override fun getItemCount(): Int {
        return mValues?.size ?: 0
    }

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val tvName = binding.tvName
        val tvId = binding.tvId
        val tvSessionList = binding.tvSessionsList
    }

    private fun clearList() {
        val emptyList = listOf<EventDTO>()
        mValues = emptyList
        notifyItemRangeRemoved(0, 0)
    }
}

interface CellClickListener {
    fun onCellClickListener(event: EventDTO)
}