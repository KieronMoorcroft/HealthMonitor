package com.coursework2.mobileapp.coursework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HealthMonitor extends AppCompatActivity {

    Button buttonTemp;
    Button buttonBloodPressure;
    Button buttonHeartRate;

    //Oncreate method that holds the links to activity xml and some functionality
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_monitor);

        //button to take user to the linked activity
        buttonTemp=(Button)findViewById(R.id.btnTemp);
        buttonTemp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), Temperature.class);
                startActivity(i);
            }
        });

        //button to take user to the linked activity
        buttonBloodPressure=(Button)findViewById(R.id.btnBpressure);
        buttonBloodPressure.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View v) {
              // TODO Auto-generated method stub
              Intent i = new Intent(getApplicationContext(),BloodPressure.class);
              startActivity(i);
              }
           }
        );
        //button to take user to the linked activity
        buttonHeartRate=(Button)findViewById(R.id.btnHeartRate);
        buttonHeartRate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), HeartRate.class);
                startActivity(i);
            }
        });
    }
}
