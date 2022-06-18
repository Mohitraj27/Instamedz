package com.example.instamedz;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.instamedz.data.DAOPatient;
import com.example.instamedz.data.Patient;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class appointment_details extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private Object v;

    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }

    public void displayToastMsg(View v) {
        toastMsg("Your Appointment details has been Submitted!!");
    }


    // create array of Strings
    // and store name of Services
    String[] courses = {"Dr. Instamedz", "Dr. Mohit Raj",
            "Dr. Devina Patel", "Dr. Instamedz",
            "Dr. Sharvesh "};

    int year, month, day, hour, minute;
    DatePickerDialog.OnDateSetListener setListener;
    String date, time;
    String Gender;
    TextInputEditText Appdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details);


        // Take the instance of Spinner and
        // apply OnItemSelectedListener on it which
        // tells which item of spinner is clicked
        final Spinner spin = findViewById(R.id.coursesspinner);
        spin.setOnItemSelectedListener(this);

        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                courses);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spin.setAdapter(ad);
        final EditText patient_name = findViewById(R.id.Patient_Name);
         RadioGroup gender = findViewById(R.id.radio);
        int selectId = gender.getCheckedRadioButtonId();
        if (selectId == R.id.radio_button_male) {
            Gender = "Male";
        } else {
            Gender = "Female";
        }
        Appdate = findViewById(R.id.datatime);
        final EditText email = findViewById(R.id.Gmail_id);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        date = new SimpleDateFormat("dd/mm/yyyy", Locale.getDefault()).format(new Date());
        time = new SimpleDateFormat("hh:mm aa", Locale.getDefault()).format(new Date());

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                month = month + 1;
                String date = year + "/" + month + "/" + day;
                //String date = year+"-"+month+"-"+day;
                Appdate.setText(date);

            }
        };

        Appdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showCalender1();
            }
        });
        final EditText phno = findViewById(R.id.Contact_No);
        DAOPatient dao = new DAOPatient();
        Button btn = findViewById(R.id.appointment_submission);
        btn.setOnClickListener(v ->
        {
            Patient patient = new Patient(spin.getSelectedItem().toString(), patient_name.getText().toString(), Gender, Appdate.getText().toString(), email.getText().toString(), phno.getText().toString());
            dao.add(patient).addOnSuccessListener(suc ->
                    {
                        Toast.makeText(this, "Record is submitted", Toast.LENGTH_SHORT).show();
                    }
            ).addOnFailureListener(er ->
            {
                Toast.makeText(this, "Record submission failed", Toast.LENGTH_SHORT).show();
            });
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // make toastof name of course
        // which is selected in spinner
        Toast.makeText(getApplicationContext(),
                        courses[position],
                        Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void showCalender1() {

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


                month = month + 1;

                String fmonth = "" + month;
                String fDate = "" + dayOfMonth;

                if (month < 10) {
                    fmonth = "0" + month;
                }
                if (dayOfMonth < 10) {
                    fDate = "0" + dayOfMonth;
                }

                String date = year + "-" + fmonth + "-" + fDate;
                //String date = year+"-"+month+"-"+day;

                Appdate.setText(date);

            }
        }, year, month, day);

        datePickerDialog.show();
    }
}