package com.example.sparky

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Task")
data class Task(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id") var id: Int,
    @ColumnInfo(name="title") var title: String,
    @ColumnInfo(name="description") var desc: String,
    @ColumnInfo(name="date") var date: String,
    @ColumnInfo(name="time") var time: String
): Parcelable
