package com.coursework2.mobileapp.coursework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BloodPressure extends AppCompatActivity {

    //Oncreate method that holds the links to activity xml and some functionality
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_pressure);

        //Button that when clicks enters the number and then set the textfield the output
        Button EnterButton = (Button) findViewById(R.id.btnBpressureEnter);
        EnterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView OutputText = (TextView) findViewById(R.id.BpressureOutputTxt);
                EditText temptxtName = (EditText) findViewById(R.id.BpressureInputTxt);
                String value = temptxtName.getText().toString();
                int finalValue = Integer.parseInt(value);

                if (finalValue <= 80) {
                    OutputText.setText("Your temperature is normal no action is required.");
                } else if (finalValue <= 110) {
                    OutputText.setText("Your temperature is at a low risk. Please take precautionary measure to avoid risk.");
                } else if (finalValue >= 110) {
                    OutputText.setText("Your temperature is at a high risk. Please alert your nurse/GP by using the message button below.");
                } else if (finalValue <= 60) {
                    OutputText.setText("Your temperature is at a high risk. Please alert your nurse/GP by using the message button below.");
                }

            }

        });
        //Button to send user to the sms activity
        Button sms =(Button)findViewById(R.id.buttonToSMS);
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), SMS.class);
                startActivity(i);
            }
        });
    }
}
