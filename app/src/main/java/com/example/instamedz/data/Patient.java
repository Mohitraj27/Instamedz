package com.example.instamedz.data;

public class Patient {
    private String drname;
    private String pname;
    private String gender;
    private String date;
    private String gmail;
    private String phno;

  //  public Patient(String s, String toString, String string, String radValue){}
public Patient(String drname,String pname,String gender,String date,String gmail,String phno ){
    this.drname = drname;
    this.pname=pname;
    this.gender=gender;
    this.date=date;
    this.gmail=gmail;
    this.phno=phno;
}


    public String getDrname() {
        return drname;
    }

    public void setDrname(String drname) {
        this.drname = drname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }
}
