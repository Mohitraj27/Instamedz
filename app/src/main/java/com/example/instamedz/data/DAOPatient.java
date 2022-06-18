package com.example.instamedz.data;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOPatient {
    private DatabaseReference databaseReference;

    public DAOPatient() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Patient.class.getSimpleName());
    }

    public Task<Void> add(Patient patient){
        return databaseReference.push().setValue(patient);
    }
}
