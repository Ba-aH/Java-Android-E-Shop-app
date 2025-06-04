package com.example.projetmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class PCAdapter extends RecyclerView.Adapter<PCAdapter.MyViewHolder> {


    Context context;

    ArrayList<PC> list;
    FirebaseDatabase fr;
    FirebaseAuth auth;
    FirebaseUser user;
    public PCAdapter(Context context, ArrayList<PC> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.pc_portable_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        fr=FirebaseDatabase.getInstance();
        PC pc = list.get(position);
        holder.reference.setText(pc.getReference());
        //holder.prix.setText(pc.getPrix());
        //holder.des.setText(pc.getDes());
        holder.prix.setText(pc.getPrix());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth = FirebaseAuth.getInstance();
                user = auth.getCurrentUser();
                HashMap<String, Object> map=new HashMap<>();
                map.put("name",user.getEmail());
                map.put("reference",pc.getReference());
                map.put("prix",pc.getPrix());
                map.put("des",pc.getDes());
                map.put("image",pc.getImg());
                    fr.getReference().child("carts").push().setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                    }
                });
            }
        });

        Glide.with(holder.img1.getContext())
                .load(pc.getImg())
                .placeholder(com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.google.firebase.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img1);




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        CircleImageView img1;
        TextView des,reference,prix;
        Button button;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //des = itemView.findViewById(R.id.tvdescription);
            img1 = itemView.findViewById(R.id.img1);
            reference = itemView.findViewById(R.id.reference);
            prix = itemView.findViewById(R.id.prix);
            button = itemView.findViewById(R.id.add_btn);
        }
    }


}
