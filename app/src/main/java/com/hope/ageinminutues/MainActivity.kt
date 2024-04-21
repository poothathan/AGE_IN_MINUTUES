package com.rcd.agecalculatorinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var selectDateValue : TextView? = null
        var minCalculateValue : TextView? = null

        var buttom : Button = findViewById(R.id.button)

        buttom.setOnClickListener{
            var cd =Calendar.getInstance()
            var year = cd.get(Calendar.YEAR)
            var month = cd.get(Calendar.MONTH)
            var date = cd.get(Calendar.DAY_OF_MONTH)

            var dpv = DatePickerDialog(this, {
                    view, selectedyear, selectedmonth, selecteddate ->
                selectDateValue = findViewById(R.id.date)

                var sel_date = "$selecteddate/${selectedmonth+1}/$selectedyear"
                selectDateValue?.text = sel_date
                minCalculateValue = findViewById(R.id.minute)

                var sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)


                var selected_date = sdf.parse(sel_date)

                var current_date = sdf.parse(sdf.format(System.currentTimeMillis()))

                var ans = (current_date.time/60000) - (selected_date.time/60000)

                minCalculateValue?.text = ans.toString()

                Toast.makeText( this,"year war $selected_date, ${selectedmonth + 1}, $selectedyear",Toast.LENGTH_LONG).show()

            },year, month, date)

            dpv.datePicker.maxDate=System.currentTimeMillis() - (86400000)
            dpv.show()
        }

    }
}