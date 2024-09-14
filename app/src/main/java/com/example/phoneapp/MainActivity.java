package com.example.phoneapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etPhoneNumber;
    Button btnCall, btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        btnCall = findViewById(R.id.btnCall);
        btnSave = findViewById(R.id.btnSave);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = etPhoneNumber.getText().toString().trim();

                if (!phoneNumber.isEmpty()) {
                    Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                    dialIntent.setData(Uri.parse("tel:" + phoneNumber));
                    startActivity(dialIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = etPhoneNumber.getText().toString().trim();

                if (!phoneNumber.isEmpty()) {
                    Intent saveIntent = new Intent(Intent.ACTION_INSERT);
                    saveIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                    saveIntent.putExtra(ContactsContract.Intents.Insert.PHONE, phoneNumber);
                    startActivity(saveIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
