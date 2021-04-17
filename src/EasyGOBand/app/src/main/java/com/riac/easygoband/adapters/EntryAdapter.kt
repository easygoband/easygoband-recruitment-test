package com.riac.easygoband.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.riac.easygoband.R
import com.riac.easygoband.models.APIResponseItem

class EntryAdapter : RecyclerView.Adapter<EntryAdapter.EntryViewHolder>() {

    inner class EntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffCallBack = object : DiffUtil.ItemCallback<APIResponseItem>() {
        override fun areItemsTheSame(oldItem: APIResponseItem, newItem: APIResponseItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: APIResponseItem,
            newItem: APIResponseItem
        ): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, diffCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        return EntryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        )
    }

    private var onItemClickListener: ((APIResponseItem) -> Unit)? = null

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val entry = differ.currentList[position]
        holder.itemView.apply {
            this.findViewById<TextView>(R.id.txtTitle).text = entry.toString()
            setOnClickListener {
                onItemClickListener?.let {
                    it(entry)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun setOnItemClickListener(listener: (APIResponseItem) -> Unit) {
        onItemClickListener = listener
    }

}