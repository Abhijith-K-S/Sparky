package com.example.sparky

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class  TaskListAdapter: RecyclerView.Adapter<TaskListAdapter.MyViewHolder>() {
    private var taskList = emptyList<Task>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTask = taskList[position]

        holder.itemView.title.text = currentTask.title
        holder.itemView.description.text = currentTask.desc
        holder.itemView.date.text = currentTask.date
        holder.itemView.time.text = currentTask.time

        holder.itemView.itemLayout.setOnClickListener()
        {
            val context = holder.itemView.context
            val intent = Intent(context,TaskUpdate::class.java)
            intent.putExtra("extra_item",currentTask)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun setData(task: List<Task>){
        this.taskList = task
        notifyDataSetChanged()
    }
}
