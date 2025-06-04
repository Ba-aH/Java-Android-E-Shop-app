package com.example.projetmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PC_List extends AppCompatActivity {
    Button button,button2,button3;
    RecyclerView recyclerView;
    DatabaseReference database;
    PCAdapter myAdapter;
    ArrayList<PC> list;
    FirebaseUser user;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc_list);
        button = findViewById(R.id.returnbtn);

        int receivedInteger = getIntent().getIntExtra("myInteger", 0);



        recyclerView = findViewById(R.id.pcList);
        DatabaseReference database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://proj-mobile-5188b-default-rtdb.europe-west1.firebasedatabase.app/");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new PCAdapter(this,list);
        recyclerView.setAdapter(myAdapter);



        database.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                auth = FirebaseAuth.getInstance();
                user = auth.getCurrentUser();
                if (receivedInteger==1){
                    for (DataSnapshot dataSnapshot : snapshot.child("PC_Portable").getChildren()){
                        String reference = dataSnapshot.child("reference").getValue(String.class);
                        String prix = dataSnapshot.child("prix").getValue(String.class);
                        String description = dataSnapshot.child("des").getValue(String.class);
                        String img = dataSnapshot.child("image").getValue(String.class);
                        PC pc = new PC(description, reference, prix, img);
                        list.add(pc);

                    }
                    myAdapter.notifyDataSetChanged();
                }

                if (receivedInteger==2){
                    for (DataSnapshot dataSnapshot : snapshot.child("smartphones").getChildren()){
                        String reference = dataSnapshot.child("reference").getValue(String.class);
                        String prix = dataSnapshot.child("prix").getValue(String.class);
                        String description = dataSnapshot.child("des").getValue(String.class);
                        String img = dataSnapshot.child("image").getValue(String.class);
                        PC pc = new PC(description, reference, prix, img);
                        button2 = findViewById(R.id.add_btn);
                        list.add(pc);

                    }
                    myAdapter.notifyDataSetChanged();
                }

                if (receivedInteger==3){
                    for (DataSnapshot dataSnapshot : snapshot.child("desktop").getChildren()){
                        String reference = dataSnapshot.child("reference").getValue(String.class);
                        String prix = dataSnapshot.child("prix").getValue(String.class);
                        String description = dataSnapshot.child("des").getValue(String.class);
                        String img = dataSnapshot.child("image").getValue(String.class);
                        PC pc = new PC(description, reference, prix, img);
                        list.add(pc);
                    }
                    myAdapter.notifyDataSetChanged();
                }

                if (receivedInteger==4){
                    for (DataSnapshot dataSnapshot : snapshot.child("console").getChildren()){
                        String reference = dataSnapshot.child("reference").getValue(String.class);
                        String prix = dataSnapshot.child("prix").getValue(String.class);
                        String description = dataSnapshot.child("des").getValue(String.class);
                        String img = dataSnapshot.child("image").getValue(String.class);
                        PC pc = new PC(description, reference, prix, img);
                        list.add(pc);
                    }
                    myAdapter.notifyDataSetChanged();
                }

                if (receivedInteger==5){
                    for (DataSnapshot dataSnapshot : snapshot.child("console").getChildren()){
                        String reference = dataSnapshot.child("reference").getValue(String.class);
                        String prix = dataSnapshot.child("prix").getValue(String.class);
                        String description = dataSnapshot.child("des").getValue(String.class);
                        String img = dataSnapshot.child("image").getValue(String.class);
                        PC pc = new PC(description, reference, prix, img);
                        list.add(pc);

                    }
                    myAdapter.notifyDataSetChanged();
                }

                if (receivedInteger==7) {
                    String user1 ;
                    String currenUser = user.getEmail();
                    for (DataSnapshot dataSnapshot : snapshot.child("carts").getChildren()) {
                         user1 = dataSnapshot.child("name").getValue(String.class);
                        if (user1.equals(currenUser)) {
                            String reference = dataSnapshot.child("").child("reference").getValue(String.class);
                            String prix = dataSnapshot.child("").child("prix").getValue(String.class);
                            String description = dataSnapshot.child("").child("des").getValue(String.class);
                            String img = dataSnapshot.child("").child("image").getValue(String.class);
                            PC pc = new PC(description, reference, prix, img);
                            list.add(pc);
                        }
                    }
                    myAdapter.notifyDataSetChanged();
                }

            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Categorie.class);
                startActivity(intent);
                finish();
            }
        });
    }


}