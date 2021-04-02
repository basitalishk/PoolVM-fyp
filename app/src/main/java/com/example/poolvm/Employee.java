package com.example.poolvm;

import java.io.Serializable;

public class Employee implements Serializable {

    String drname="";
    String drnum="";
    String dradd="";
    String drcnic="";
    String drbus="";
    String dremail="";

    public Employee()
    {

    }

    public Employee (String drname1,String drnum1,String dradd1,String drcnic1,String drbus1,String dremail1)
    {

        drname=drname1;
        drnum = drnum1;
        dradd= dradd1;
        drcnic=drcnic1;
        drbus=drbus1;
        dremail=dremail1;


    }

}
