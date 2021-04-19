package com.example.exampledialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
  TextView timetv,datetv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timetv=findViewById(R.id.timetv);
        datetv=findViewById(R.id.datetv);
    }

    public void alert(View view) {


        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("AlertDialog");
        builder.setMessage("Do you want to exit?");
        builder.setIcon(R.drawable.ic_act);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void date(View view) {
        Calendar c= Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day =c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                datetv.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        },year,month,day);
        dpd.show();
    }

    public void time(View view) {

        Calendar c= Calendar.getInstance();
        int hour=c.get(Calendar.HOUR);
        int minute= c.get(Calendar.MINUTE);
        TimePickerDialog tpd=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                timetv.setText(hour+":"+minute);
            }
        },hour,minute,false);

    }
}