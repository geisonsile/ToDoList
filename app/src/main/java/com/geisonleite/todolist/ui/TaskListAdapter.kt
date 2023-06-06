package com.geisonleite.todolist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geisonleite.todolist.databinding.ItemTaskBinding
import com.geisonleite.todolist.model.Task

class TaskListAdapter: ListAdapter<Task, TaskListAdapter.TaskViewHolder>(DiffCallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTaskBinding.inflate(inflater, parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
       holder.bind(getItem(position))
    }

    class TaskViewHolder(
        private val binding: ItemTaskBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Task){
            binding.tvTitle.text = item.title
            binding.tvDateHour.text = "${item.date} ${item.hour}"
        }
    }
}

class DiffCallBack : DiffUtil.ItemCallback<Task>(){
    override fun areItemsTheSame(oldItem: Task, newItem: Task) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Task, newItem: Task) = oldItem.id == newItem.id
}