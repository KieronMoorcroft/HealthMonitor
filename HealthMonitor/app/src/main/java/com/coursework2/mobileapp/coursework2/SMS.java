package com.coursework2.mobileapp.coursework2;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMS extends AppCompatActivity {

    private Button contact;
    public int recode = 1;

    //Oncreate method that holds the links to activity xml and some functionality
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        // The button that access the devics contacts
        contact = (Button) findViewById(R.id.btnContact);
        contact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                // Calling the contacts with an intent
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                startActivityForResult(i, recode);
            }

        });
        // Send button takes the edittextview "editMessageTxt" and then parses into the sendSMS method
        Button btnSendSMS = (Button) findViewById(R.id.btnSend);
        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText userNumber = (EditText) findViewById(R.id.editContact);
                String numberValue = userNumber.getText().toString();

                EditText temptxtName = (EditText) findViewById(R.id.editMessageTxt);
                String value = temptxtName.getText().toString();
                sendSMS(numberValue,value);
                Toast.makeText(getBaseContext(), "SMS sent",
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
    // Take the number from the contacts
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            Uri uri = data.getData();
            Log.i("data", uri.toString());
            if (uri != null) {
                Cursor c = null;
                try {
                    c = getContentResolver().query(uri, new String[] {ContactsContract.CommonDataKinds.Phone.NUMBER,}, null, null, null);

                    if (c != null && c.moveToFirst()) {
                        String number = c.getString(1);

                        showSelectedNumber(number);
                    }
                } finally {
                    if (c != null) {
                        c.close();
                    }
                }
            }
        }
    }

    // Show the number taken from the contact into the EditText userNumber
    public void showSelectedNumber(String number) {
        EditText userNumber = (EditText) findViewById(R.id.editContact);
        userNumber.setText(number);

    }
    // Send SMS to with number and message
    private void sendSMS(String phoneNumber, String message){
        SmsManager sms=SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }

}
