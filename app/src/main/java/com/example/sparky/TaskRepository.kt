package com.example.sparky

import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: LiveData<List<Task>> = TaskDao.getAllTasks()

    suspend fun insert(task: Task)
    {
        TaskDao.insertTask(task)
    }

    suspend fun delete(task: Task)
    {
        TaskDao.deleteTask(task)
    }
    
}