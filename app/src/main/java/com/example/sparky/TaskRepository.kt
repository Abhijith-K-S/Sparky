package com.example.sparky

import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: LiveData<List<Task>> = taskDao.getAllTasks()

    suspend fun insert(task: Task)
    {
        taskDao.insertTask(task)
    }

    suspend fun delete(task: Task)
    {
        taskDao.deleteTask(task)
    }

    suspend fun update(task: Task)
    {
        taskDao.updateTask((task))
    }
}