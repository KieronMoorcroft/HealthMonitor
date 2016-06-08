package com.coursework2.mobileapp.coursework2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

//Button fields
    Button buttonHM;
    Button buttonSignIn;
    Button buttonSignUp;
    Button buttonSettings;

    //Oncreate method that holds the links to activity xml and some functionality
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button to take user to the linked activity
        buttonHM=(Button)findViewById(R.id.btnHealthMonitor);
        buttonHM.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), HealthMonitor.class);
                startActivity(i);
            }
        });
        //button to take user to the linked activity
        buttonSignIn=(Button)findViewById(R.id.btnsignIn);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
             // TODO Auto-generated method stub
             Intent i = new Intent(getApplicationContext(),Login.class);
             startActivity(i);
                }
             }
        );

        //button to take user to the linked activity
        buttonSignUp=(Button)findViewById(R.id.btnSignUP);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),SignUp.class);
                startActivity(i);
            }
        });

        //button to take user to the linked activity
        buttonSettings=(Button)findViewById(R.id.btnSettings);
        buttonSettings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),SignUp.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
