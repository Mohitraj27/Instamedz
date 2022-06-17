package com.example.instamedz;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class appointment_details extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {


    private Object v;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Button submit;
    private EditText editTextName, editTextDoA, editTextGender, editTextEmail, editTextPhNo;
    String email = editTextEmail.getText().toString().trim();
    String PTname = editTextName.getText().toString().trim();
    String DoA=editTextDoA.getText().toString().trim();
    String PhNo=editTextPhNo.getText().toString().trim();

    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
    public void displayToastMsg(View v) {
        toastMsg("Your Appointment details has been Submitted!!");
    }


    // create array of Strings
    // and store name of Services
    String[] courses = { "Dr. Instamedz", "Dr. Mohit Raj",
            "Dr. Devina Patel", "Dr. Gunal",
            "Dr. Sharvesh " };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details);
        // Take the instance of Spinner and
        // apply OnItemSelectedListener on it which
        // tells which item of spinner is clicked
        Spinner spin = findViewById(R.id.coursesspinner);
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
        editTextDoA=(EditText)findViewById(R.id.Appoint_DOA);
        editTextEmail=(EditText)findViewById(R.id.Gmail_id);
        editTextPhNo=(EditText)findViewById(R.id.Contact_No);

        submit=(Button) findViewById(R.id.appointment_submission);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppointUser();
            }
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
    public void AppointUser()
    {


        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("Patient Name", PTname);
        user.put("Email", email);
        user.put("Date Of Appointment", DoA);
        user.put("Phone Number",PhNo);

        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(appointment_details.this,"Appointment Registered!",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(appointment_details.this,"Errpr -"+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}