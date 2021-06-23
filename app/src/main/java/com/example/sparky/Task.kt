package com.example.sparky

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
data class Task(
    @ColumnInfo(name="title") var title: String,
    @ColumnInfo(name="description") var desc: String,
    @ColumnInfo(name="date") var date: String,
    @ColumnInfo(name="time") var time: String
)
{
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="id") var id: Int = 0
}