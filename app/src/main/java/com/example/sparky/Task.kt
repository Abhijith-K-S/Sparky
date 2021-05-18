package com.example.sparky

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
class Task(val title:String, val desc:String, val date:String, val time:String)
{
    @PrimaryKey(autoGenerate = true) val id=0
}