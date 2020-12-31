package com.example.main_interface

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(private val TaskList: List<Task>) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val diaryNote: TextView = view.findViewById(R.id.note)
        val money: TextView = view.findViewById(R.id.money)
        val image: ImageView = view.findViewById(R.id.image0)
        val user2: TextView = view.findViewById(R.id.user1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.diary_note, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val task = TaskList[position]
            val intent = Intent(it.context, Receive::class.java)
            intent.putExtra("note", task.content)
            intent.putExtra("money", task.money)
            it.context.startActivity(intent)
        }
        return viewHolder
    }

    override fun getItemCount() = TaskList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = TaskList[position]
        holder.diaryNote.text = note.content
        holder.money.text = note.money
        holder.image.setImageResource(note.imageId)
        holder.user2.text = note.user0
    }

}

