package com.example.sparky

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var taskViewModel: TaskViewModel

        val space = ItemSpace()
        val adapter = TaskListAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val emptyView = findViewById<TextView>(R.id.emptyView)

        recyclerView.addItemDecoration(space)
        recyclerView.adapter = adapter
        adapter.registerAdapterDataObserver(EmptyDataObserver(recyclerView,emptyView))
        recyclerView.layoutManager = LinearLayoutManager(this)

        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        taskViewModel.allTasks.observe(this,Observer{ task->
            adapter.setData((task))
        })

        val create = findViewById<FloatingActionButton>(R.id.createTaskButton)

        create.setOnClickListener()
        {
            startActivity(Intent(this,TaskInput::class.java))
        }
    }
}