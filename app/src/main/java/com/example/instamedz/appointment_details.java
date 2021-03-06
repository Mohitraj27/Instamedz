package com.example.instamedz;

import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class appointment_details extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {



    private ImageView EyeCare_User_logout;


    private Object v;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Button submit;
    private EditText editTextName, editTextDoA, editTextEmail, editTextPhNo;
    private String gender="Unknown";
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Spinner spin;
    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
    /*public void displayToastMsg(View v) {
        toastMsg("Your Appointment details has been Submitted!!");
    }*/


    // create array of Strings
    // and store name of Services
    String[] courses = { "Dr. Instamedz", "Dr. Mohit Raj",
            "Dr. Devina Patel", "Dr. Instamedz",
            "Dr. Devina Patel", "Dr. Gunal",
            "Dr. Sharvesh " };


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details);


        //Book your appointment Notification
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("doctor_appointement", "doctor_appointement", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager =getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"doctor_appointement")
                .setContentTitle("Book your Appointment Now!!")
                .setSmallIcon(R.drawable.instamedz2)
                .setAutoCancel(true)
                .setContentText("We have the team of Best doctors as per your need");

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(1111,builder.build());






        EyeCare_User_logout=findViewById(R.id.eye_care_user_lgout);
        EyeCare_User_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(appointment_details.this, UserProfile.class);
                startActivity(intent);
            }
        });

        // Take the instance of Spinner and
        // apply OnItemSelectedListener on it which
        // tells which item of spinner is clicked
        spin = findViewById(R.id.coursesspinner);
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
        editTextName=(EditText)findViewById(R.id.Patient_Name);
        editTextEmail=(EditText)findViewById(R.id.Gmail_id);
        editTextPhNo=(EditText)findViewById(R.id.Contact_No);
        editTextDoA=findViewById(R.id.datatime);
        final Calendar calendar= Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        editTextDoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog=new DatePickerDialog(appointment_details.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        month=month+1;
                        String date= dayOfMonth+"/"+month+"/"+year;
                        editTextDoA.setText(date);
                    }
                },year, month,day);
                dialog.show();
            }
        });
        radioGroup=(RadioGroup)findViewById(R.id.radio);
        RadioButton genderBtn=(RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
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
    public void AppointUser(View view)
    {
        String email = editTextEmail.getText().toString().trim();
        String PTname = editTextName.getText().toString().trim();
        String DoA=editTextDoA.getText().toString().trim();
        String PhNo=editTextPhNo.getText().toString().trim();
        String DrName=spin.getSelectedItem().toString();
        int ID=radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(ID);
        gender=radioButton.getText().toString();
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("Patient Name", PTname);
        user.put("Email", email);
        user.put("Doctor Name",DrName);
        user.put("Date Of Appointment", DoA);
        user.put("Phone Number",PhNo);
        user.put("Gender",gender);

        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(appointment_details.this,"Your Appointment has been booked Successfully!!",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(appointment_details.this,"Error -"+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        }
}
