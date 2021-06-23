package com.example.sparky

import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_task_input.*
import java.util.*

class TaskInput : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    private var currentDay = 0
    private var currentMonth = 0
    private var currentYear = 0
    private var currentHour = 0
    private var currentMinute = 0

    private var savedDay = 0
    private var savedMonth = 0
    private var savedYear = 0
    private var savedHour = 0
    private var savedMinute = 0

    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_input)

        dateButton.setOnClickListener()
        {
            getDateCalendar()
            DatePickerDialog(this,this,currentYear,currentMonth,currentDay).show()
        }

        timeButton.setOnClickListener()
        {
            getTimeCalendar()
            TimePickerDialog(this,this,currentHour,currentMinute,false).show()
        }

        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        createTaskButton.setOnClickListener()
        {
            var flag = true
            if(newTaskTitleBox.text.equals("")) {
                showToast("Please enter a valid title!")
                flag = false
            }
            if(newDateTextBox.text.equals("")) {
                showToast("Please enter a valid date!")
                flag = false
            }
            if(newTimeTextBox.text.equals("")) {
                flag = false
                showToast("Please enter a valid time!")
            }

            if(flag)
            {
                val title = newTaskTitleBox.text.toString()
                var desc = "No Description"
                if(newDescTextBox.text.isNotEmpty())
                    desc = newDescTextBox.text.toString()
                val date = newDateTextBox.text.toString()
                val time = newTimeTextBox.text.toString()

                taskViewModel.insert(Task(title,desc,date,time))
                showToast("Task successfully added!")
                finish()
            }
        }
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("You have unsaved changes. Are you sure you want to go back?")
            .setPositiveButton(android.R.string.ok) { dialog, whichButton ->
                super.onBackPressed()
            }
            .setNegativeButton(android.R.string.cancel) { dialog, whichButton ->

            }
            .show()
    }

    private fun showToast(message: String)
    {
        val toast = Toast.makeText(this,message,Toast.LENGTH_SHORT)
        toast.show()
    }

    private fun getDateCalendar()
    {
        val cal = Calendar.getInstance()
        currentDay = cal.get(Calendar.DAY_OF_MONTH)
        currentMonth  = cal.get(Calendar.MONTH)
        currentYear = cal.get(Calendar.YEAR)
    }

    private fun getTimeCalendar()
    {
        val cal = Calendar.getInstance()
        currentHour = cal.get(Calendar.HOUR_OF_DAY)
        currentMinute = cal.get(Calendar.MINUTE)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year

        var flag=1
        if(savedYear<currentYear)
            flag=-1
        else if(savedYear==currentYear && savedMonth<currentMonth)
            flag=-1
        else if(savedYear==currentYear && savedMonth==currentMonth && savedDay<currentDay)
            flag=-1

        if(flag==1)
            newDateTextBox.text = "$savedDay / $savedMonth / $savedYear"
        else
            showToast("Please enter a valid date!")
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {

        savedHour = hourOfDay
        savedMinute = minute

        var displayHour: String
        var displayMinute: String
        var status: String

        if(savedHour>12)
        {
            displayHour=(savedHour-12).toString()
            status="PM"
        }
        else
        {
            displayHour = savedHour.toString()
            status="AM"
        }

        displayMinute = savedMinute.toString()

        if(displayHour.toInt()<10)
            displayHour="0$displayHour"

        if(displayMinute.toInt()<10)
            displayMinute="0$displayMinute"

        newTimeTextBox.text = "$displayHour:$displayMinute  $status"
    }
}
