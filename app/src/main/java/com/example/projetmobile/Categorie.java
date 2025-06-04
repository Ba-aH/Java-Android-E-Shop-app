package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Categorie extends AppCompatActivity {
    Button button,button1,button2,button3,button4,button5,button6,button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        button = findViewById(R.id.logout2);
        button1 = findViewById(R.id.laptops);
        button2 = findViewById(R.id.bt_smartphones);
        button3 = findViewById(R.id.bt_desktop);
        button4 = findViewById(R.id.bt_console);
        button5 = findViewById(R.id.cart_btn);
        button6 = findViewById(R.id.cart_btn);
        button7 = findViewById(R.id.cart_btn1);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PC_List.class);
                intent.putExtra("myInteger", 1);
                startActivity(intent);
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PC_List.class);
                intent.putExtra("myInteger", 2);
                startActivity(intent);
                finish();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PC_List.class);
                intent.putExtra("myInteger", 3);
                startActivity(intent);
                finish();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PC_List.class);
                intent.putExtra("myInteger", 4);
                startActivity(intent);
                finish();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PC_List.class);
                intent.putExtra("myInteger", 5);
                startActivity(intent);
                finish();
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PC_List.class);
                intent.putExtra("myInteger", 7);
                startActivity(intent);
                finish();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),aboutUs.class);
                startActivity(intent);
                finish();
            }
        });


    }


}