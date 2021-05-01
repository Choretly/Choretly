package com.example.choretly;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.choretly.Models.Agenda;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

public class AgendaAdapter extends FirebaseRecyclerAdapter<Agenda, AgendaAdapter.AgendaViewholder> {

    public AgendaAdapter(@NonNull FirebaseRecyclerOptions<Agenda> options)
    {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void onBindViewHolder(@NonNull AgendaAdapter.AgendaViewholder holder,
                                    int position, @NonNull Agenda model)
    {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.jobIdNum.setText(model.getJobId());
        holder.jTitle2.setText(model.getJobName());
        holder.jobTime.setText(model.getJobTime());

    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public AgendaAdapter.AgendaViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_agenda, parent, false);
        return new AgendaAdapter.AgendaViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class AgendaViewholder extends RecyclerView.ViewHolder {
        TextView jobIdNum;
        TextView jTitle2;
        TextView jobTime;

        public AgendaViewholder(@NonNull View itemView)
        {
            super(itemView);

            jobIdNum = itemView.findViewById(R.id.jobIdNum);
            jTitle2 = itemView.findViewById(R.id.jTitle2);
            jobTime = itemView.findViewById(R.id.jobTime);


        }
    }
}
