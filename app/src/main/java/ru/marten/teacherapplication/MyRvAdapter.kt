package ru.marten.teacherapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRvAdapter(private val elements: List<String>): RecyclerView.Adapter<MyRvAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = elements.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = elements[position]
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val text = itemView.findViewById<TextView>(R.id.text)
    }
}