package com.example.gosuslygi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText dateText, timeText;

    ImageButton dateImage, timeImage;

    Button createButton;

    Date date = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateText = findViewById(R.id.dateText);
        timeText = findViewById(R.id.timeText);
        dateImage = findViewById(R.id.dateImage);
        timeImage = findViewById(R.id.timeImage);
        createButton = findViewById(R.id.createButton);

        dateImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedYear = date.getYear();
                int selectedMonth = date.getMonth();
                int selectedDay = date.getDay();

                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dateText.setText(""+i+"-"+(i1+1)+"-"+i2);

                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,dateSetListener, selectedYear, selectedMonth, selectedDay);
                datePickerDialog.show();
            }
        });

        timeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean bool = true;
                int selectedHour = date.getHours();
                int selectedMinutes = date.getMinutes();

                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        timeText.setText(i+":"+i1);
                    }
                };

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, timeSetListener, selectedHour, selectedMinutes, bool);
                timePickerDialog.show();
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Окошко от которого ничего не произойлет сейчас")
                        .setMessage("Вообще ничего. Реально!")
                        .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(MainActivity.this, "Ничего не произошло", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .create();
                builder.show();

            }
        });
    }


}