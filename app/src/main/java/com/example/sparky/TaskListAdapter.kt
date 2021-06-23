package com.example.sparky

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_task_input.view.*
import kotlinx.android.synthetic.main.item.view.*

class  TaskListAdapter: RecyclerView.Adapter<TaskListAdapter.MyViewHolder>() {
    private var taskList = emptyList<Task>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: TaskListAdapter.MyViewHolder, position: Int) {
        val currentTask = taskList[position]

        holder.itemView.title.text = currentTask.title
        holder.itemView.description.text = currentTask.desc
        holder.itemView.date.text = currentTask.date
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun setData(task: List<Task>){
        this.taskList = task
        notifyDataSetChanged()
    }
}
