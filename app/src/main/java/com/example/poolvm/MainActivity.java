package com.example.poolvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this, Register_Driver.class);
        finish();
        startActivity(i);



        //Register Driver = For Registration of Driver
        //AssignBus = To assign new bus to driver //Enter Correct Driver Number else app crashes.
        //Maps Activity = Shows Maps of Peshawar with two Marker (City University & One Bus Location) and current Location
    }
}