package com.example.projetmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.ObservableSnapshotArray;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    Button button,button2;
    TextView textView;
    FirebaseUser user;

    RecyclerView recyclerView;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
        button2 = findViewById(R.id.pcs);
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();

        if (user ==null){
            Intent intent = new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
            finish();
        }
        else {
            Intent intent = new Intent(getApplicationContext(),Categorie.class);
            startActivity(intent);
            finish();
        }

        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("PC_Portable");
        databaseReference.addValueEventListener(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                        String value = snapshot.getValue(String.class);

                                                    }

                                                    @Override
                                                    public void onCancelled(@NonNull DatabaseError error) {

                                                    }
                                                });*/


        FirebaseRecyclerOptions<PC_PORTABLE> options =
                new FirebaseRecyclerOptions.Builder<PC_PORTABLE>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("PC_Portable"), PC_PORTABLE.class)
                        .build();

        ObservableSnapshotArray<PC_PORTABLE> snapshot = options.getSnapshots();



        Toast.makeText(MainActivity.this, "mydata.",
                Toast.LENGTH_SHORT).show();

        /*FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Products")
                        .get().addOnSuccessListener(queryDocumentSnapshots -> {
                            ArrayList<PC_PORTABLE> pc = new ArrayList<PC_PORTABLE>();
                            for (DocumentSnapshot document : queryDocumentSnapshots.getDocuments()) {
                                Map data = document.getData();
                                String reference = data.get("reference").toString();
                                String img = data.get("img").toString();
                                int prix = Integer.parseInt(data.get("prix").toString());
                                PC_PORTABLE npc = new PC_PORTABLE(img,prix,reference);
                                pc.add(npc);
                            }
                            pcPortableAdapter = new PC_Portable_Adapter(pc);
                            recyclerView.setAdapter(pcPortableAdapter);
                });*/



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PC_List.class);
                startActivity(intent);
                finish();
            }
        });

    }
   /*  @Override
    protected void onStart() {
        super.onStart();
        pcPortableAdapter.startListening();
    }

   @Override
    protected void onStop() {
        super.onStop();
        pcPortableAdapter.stopListening();
    }*/
}