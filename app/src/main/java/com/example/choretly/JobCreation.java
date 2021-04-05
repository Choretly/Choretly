package com.example.choretly;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class JobCreation extends AppCompatActivity {

    private Button jcSaveBtn;
    private Button jcCancelBtn;
    private DatabaseReference jcDatabase;
    private EditText jcNameField;
    private EditText jcJobTypeField;
    private EditText jcAddressField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_creation);

        jcSaveBtn = (Button) findViewById(R.id.save_btn);
        jcCancelBtn = (Button) findViewById(R.id.cancel_btn);
        jcDatabase = FirebaseDatabase.getInstance().getReference();
        jcNameField = (EditText) findViewById(R.id.name_field);
        jcJobTypeField = (EditText) findViewById(R.id.jobType_field);
        jcAddressField = (EditText) findViewById(R.id.address_field);

        jcSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = jcNameField.getText().toString().trim();
                String jobType = jcJobTypeField.getText().toString().trim();
                String address = jcAddressField.getText().toString().trim();

                HashMap<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("Name", name);
                dataMap.put("Job Type", jobType);
                dataMap.put("Address", address);

                jcDatabase.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        
                         if(task.isSuccessful()){

                             Toast.makeText(JobCreation.this, "Stored!", Toast.LENGTH_LONG).show();

                         }else{
                             Toast.makeText(JobCreation.this, "Error!", Toast.LENGTH_LONG).show();
                         }
                    }
                });

            }
        });
    }
}
