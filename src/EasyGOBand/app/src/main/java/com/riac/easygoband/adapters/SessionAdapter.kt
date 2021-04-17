package com.riac.easygoband.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.riac.easygoband.R
import com.riac.easygoband.models.Session

class SessionAdapter : RecyclerView.Adapter<SessionAdapter.SessionViewHolder>() {
    inner class SessionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffCallBack = object : DiffUtil.ItemCallback<Session>() {
        override fun areItemsTheSame(oldItem: Session, newItem: Session): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Session,
            newItem: Session
        ): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, diffCallBack)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        return SessionViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        val session = differ.currentList[position]
        holder.itemView.apply {
            this.findViewById<TextView>(R.id.txtTitle).text = session.toString()
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}