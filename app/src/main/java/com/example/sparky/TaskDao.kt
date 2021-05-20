package com.example.sparky

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {
    @Insert(OnConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: Task)
    {

    }

    @Delete
    suspend fun deleteTask(task: Task)
    {

    }

    @Query(value="select * from task order by id ASC")
    fun getAllTasks(): LiveData<List<Task>>
}