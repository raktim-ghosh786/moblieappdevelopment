package com.example.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter(private val onItemClicked: (ToDo) -> Unit) :
    ListAdapter<ToDo, ToDoAdapter.ToDoViewHolder>(ToDoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo, parent, false)
        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClicked)
    }

    class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val checkBoxTask: CheckBox = itemView.findViewById(R.id.checkBoxTask)

        fun bind(toDo: ToDo, onItemClicked: (ToDo) -> Unit) {
            checkBoxTask.text = toDo.task
            checkBoxTask.isChecked = toDo.completed

            checkBoxTask.setOnClickListener {
                // Update task completion status
                toDo.completed = checkBoxTask.isChecked
                onItemClicked(toDo)
            }

            itemView.setOnClickListener {
                onItemClicked(toDo)
            }
        }
    }

    class ToDoDiffCallback : DiffUtil.ItemCallback<ToDo>() {
        override fun areItemsTheSame(oldItem: ToDo, newItem: ToDo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ToDo, newItem: ToDo): Boolean {
            return oldItem == newItem
        }
    }
}
