package com.example.poolvm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class Register_Driver extends AppCompatActivity {

    private EditText dname,dnum,dadd,dcnic,dbus,demail,dpass;
    private FirebaseAuth mAuth;
    private FirebaseDatabase databaseReference;

  public  Employee driver;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__driver);


        mAuth = FirebaseAuth.getInstance();


        dname=(EditText)findViewById(R.id.dname);
        dnum= (EditText)findViewById(R.id.dnumber);
        dadd=(EditText)findViewById(R.id.daddress);
        dcnic=(EditText)findViewById(R.id.dcnic);
        dbus=(EditText)findViewById(R.id.dbus);
        demail=(EditText)findViewById(R.id.demail);
        dpass=(EditText)findViewById(R.id.dpass);


    }


    public void RegisterDriver(View view)
    {
     String drname,drnum,dradd,drcnic,drbus,dremail,drpass;

        drname=dname.getText().toString();
        drnum = dnum.getText().toString();
        dradd= dadd.getText().toString();
        drcnic=dcnic.getText().toString();
        drbus=dbus.getText().toString();
        dremail=demail.getText().toString();
        drpass=dpass.getText().toString();

        driver = new Employee(drname,drnum,dradd,drcnic,drbus,dremail);

        // mAuth.createUserWithEmailAndPassword(dremail, drpass)

        mAuth.createUserWithEmailAndPassword(dremail, drpass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser u = mAuth.getCurrentUser();

                            FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
                            DatabaseReference mDatabaseReference = mDatabase.getReference("Driver");

                            mDatabaseReference.child(drnum).child("Dname").setValue(drname);
                            mDatabaseReference.child(drnum).child("Dnum").setValue(drnum);
                            mDatabaseReference.child(drnum).child("Dadd").setValue(dradd);
                            mDatabaseReference.child(drnum).child("Dcnic").setValue(drcnic);
                            mDatabaseReference.child(drnum).child("Dbus").setValue(drbus);
                            mDatabaseReference.child(drnum).child("Demail").setValue(dremail);



                            Toast.makeText(Register_Driver.this, "User Created", Toast.LENGTH_SHORT).show();


                            Log.d("SignIN Notification", "createUserWithEmail:success");

                        } else
                            {

                                Toast.makeText(Register_Driver.this, "Failed", Toast.LENGTH_SHORT).show();

                                // If sign in fails, display a message to the user.

                        }
                    }
                });


    }
}