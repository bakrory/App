package com.example.maintance_reg_screen1;

import android.icu.text.IDNA;

import java.util.Random;

public class code_control {
    private String email, name, fname, Lname, rndans, rndtxt;
    private int password, phone, cphone;

    public String getRndtxt() {
        return rndtxt;
    }

    public void setRndtxt(String rndtxt) {
        this.rndtxt = rndtxt;
    }

    public String getEmail() {
        return email;
    }

    public String getRndans() {
        return rndans;
    }

    public void setRndans(String rndans) {
        this.rndans = rndans;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getCphone() {
        return cphone;
    }

    public void setCphone(int cphone) {
        this.cphone = cphone;
    }
//*******************************************METHOD**************************

    public String randtxt(){
        Random r=new Random();
        int x=r.nextInt(122-97+1)+97;
        int y=r.nextInt(122-97+1)+97;
        int z=r.nextInt(122-97+1)+97;
        int c=r.nextInt(122-97+1)+97;
        char s=(char)x;
        char l=(char)y;
        char i=(char)z;
        char q=(char)c;
        String f=s+""+l+""+""+i+""+q;

         return f;


    }



}
