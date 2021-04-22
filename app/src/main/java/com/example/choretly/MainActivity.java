package com.example.choretly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import com.example.choretly.Models.Agenda;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    AgendaAdapter adapter;
    DatabaseReference mdatabase;
//    private FirebaseAuth mAuth;
    private String uid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        // Create a instance of the database and get
        // its reference
        mdatabase = FirebaseDatabase.getInstance().getReference().child("charles").child("JobList");

//        mAuth = FirebaseAuth.getInstance();
//        uid = mAuth.getUid();

        recyclerView = findViewById(R.id.rvAgenda);

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data
        FirebaseRecyclerOptions<Agenda> options = new FirebaseRecyclerOptions.Builder<Agenda>().setQuery(mdatabase, Agenda.class).build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        adapter = new AgendaAdapter(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);
//        Button back_button = findViewById(R.id.backButton2);
//        back_button.setOnClickListener(this::onClick);
    }

    // Function to tell the app to start getting
    // data from database on starting of the activity
    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }


}