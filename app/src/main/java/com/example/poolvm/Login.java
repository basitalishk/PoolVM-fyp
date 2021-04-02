package com.example.poolvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText email;
    private EditText pass;



    String username,e;
    String password,p;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.login_emailid);
        pass = (EditText) findViewById(R.id.login_password);



    }

    public void Login(View view)
    {
        e=email.getText().toString();
        p=pass.getText().toString();

        if(e.equals("admin")&& p.equals("admin"))
        {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent i =new Intent(this ,Register_Driver.class);
            email.setText("");
            pass.setText("");
            finish();
            startActivity(i);

        }
        else
        {
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG).show();
        }

    }
}