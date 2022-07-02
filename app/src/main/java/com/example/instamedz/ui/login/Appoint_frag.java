package com.example.instamedz.ui.login;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.instamedz.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Appoint_frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Appoint_frag extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView EyeCare_User_logout;


    private Object v;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Button submit;
    private EditText editTextName, editTextDoA, editTextEmail, editTextPhNo;
    private String gender = "Unknown";
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Spinner spin;
    private int ID;
    String[] courses = {"Dr. Instamedz", "Dr. Mohit Raj",
            "Dr. Devina Patel", "Dr. Instamedz",
            "Dr. Devina Patel", "Dr. Gunal",
            "Dr. Sharvesh "};

    public Appoint_frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Appoint_frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Appoint_frag newInstance(String param1, String param2) {
        Appoint_frag fragment = new Appoint_frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_appoint_frag, container, false);
        EyeCare_User_logout = v.findViewById(R.id.eye_care_user_lgout);
        EyeCare_User_logout.setOnClickListener(this);
        v.findViewById(R.id.appointment_submission).setOnClickListener(this);
        // Take the instance of Spinner and
        // apply OnItemSelectedListener on it which
        // tells which item of spinner is clicked
        spin = v.findViewById(R.id.coursesspinner);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                Object item = adapterView.getItemAtPosition(position);
                if (item != null) {
                    Toast.makeText(getContext(), item.toString(),
                            Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub

            }
        });

        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, courses);
        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spin.setAdapter(ad);
        editTextName = (EditText) v.findViewById(R.id.Patient_Name);
        editTextEmail = (EditText) v.findViewById(R.id.Gmail_id);
        editTextPhNo = (EditText) v.findViewById(R.id.Contact_No);
        editTextDoA = v.findViewById(R.id.datatime);
        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        editTextDoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = dayOfMonth + "/" + month + "/" + year;
                        editTextDoA.setText(date);
                    }
                }, year, month, day);
                dialog.show();
            }
        });
        radioGroup = (RadioGroup) v.findViewById(R.id.radio);
        ID = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) v.findViewById(ID);
        return v;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Home_FrameLayout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.appointment_submission:
                AppointUser();
                break;
        }
    }
    public void AppointUser()
    {
        //RadioButton genderBtn = (RadioButton) v.findViewById(radioGroup.getCheckedRadioButtonId());
        String email = editTextEmail.getText().toString().trim();
        String PTname = editTextName.getText().toString().trim();
        String DoA = editTextDoA.getText().toString().trim();
        String PhNo = editTextPhNo.getText().toString().trim();
        String DrName = spin.getSelectedItem().toString();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_button_male:
                        gender = "Male";
                        break;
                    case R.id.radio_button_female:
                        gender = "Female";
                        break;
                }
            }
        });
        //gender = radioButton.getText().toString();
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("Patient Name", PTname);
        user.put("Email", email);
        user.put("Doctor Name", DrName);
        user.put("Date Of Appointment", DoA);
        user.put("Phone Number", PhNo);
        user.put("Gender", gender);

        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getContext(), "Your Appointment has been booked Successfully!!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), "Error -" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
