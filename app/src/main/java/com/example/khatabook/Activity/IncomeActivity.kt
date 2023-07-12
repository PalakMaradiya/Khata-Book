package com.example.khatabook.Activity

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import com.example.khatabook.databinding.ActivityIncomeBinding
import java.text.SimpleDateFormat
import java.util.*

class IncomeActivity : AppCompatActivity() {
    lateinit var  binding: ActivityIncomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityIncomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {

        val myCalendar = Calendar.getInstance()
        val datapicker = DatePickerDialog.OnDateSetListener { view, year, month, dayofmonth ->

            myCalendar.set(Calendar.DAY_OF_MONTH, dayofmonth)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.YEAR, year)
            updateLabal(myCalendar)

        }
        binding.txtDate.setOnClickListener {

            DatePickerDialog(
                this, datapicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
           }


    }


    private fun updateLabal(myCalendar: Calendar) {


        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        binding.txtDate.setText(sdf.format(myCalendar.time))

        }


}

