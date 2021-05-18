package com.example.sparky

import androidx.room.*

@Dao
interface TaskDao {
    @Insert(OnConflict = OnConflictStrategy.IGNORE)
    fun insertTask(task: Task)
    {

    }

    @Delete
    fun deleteTask(task: Task)
    {

    }
}