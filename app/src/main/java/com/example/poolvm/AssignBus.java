package com.example.poolvm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class AssignBus extends AppCompatActivity {

    private EditText dnum,dbus;
    private TextView tname,tcnic,tbus;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_bus);

        dnum= (EditText)findViewById(R.id.dnumber);
        dbus=(EditText)findViewById(R.id.dbus);
        tname=(TextView) findViewById(R.id.dname);
        tcnic=(TextView) findViewById(R.id.dcnic);
        tbus=(TextView) findViewById(R.id.doldbus);

    }

    public void AssignBus(View view)
    {
        String drnum,drbus;

        drnum = dnum.getText().toString();
        drbus=dbus.getText().toString();

        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mDatabaseReference = mDatabase.getReference("Driver");

  mDatabaseReference.child(drnum).child("Dbus").setValue(drbus);



    }

    public void GetDriver(View view)
    {


        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mDatabaseReference = mDatabase.getReference("Driver");

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                String drnum;
                drnum = dnum.getText().toString();
                String check1= snapshot.child(drnum).child("Dnum").getValue().toString();

               // Toast.makeText(AssignBus.this, check1, Toast.LENGTH_SHORT).show();

                   // Toast.makeText(AssignBus.this, snapshot.getValue().toString(), Toast.LENGTH_SHORT).show();

                    String a = snapshot.child(drnum).child("Dbus").getValue().toString();
                    String b = snapshot.child(drnum).child("Dname").getValue().toString();
                    String c = snapshot.child(drnum).child("Dcnic").getValue().toString();

                    tbus.setText("Currently Assigned Bus: " + a);
                    tcnic.setText("Driver's CNIC No: " + c);
                    tname.setText("Driver's Name: " + b);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}