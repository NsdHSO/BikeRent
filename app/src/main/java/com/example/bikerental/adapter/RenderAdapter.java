package com.example.bikerental.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bikerental.R;
import com.example.bikerental.dbModel.ModelDb;
import com.example.bikerental.renterModel.Renter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;

public class RenderAdapter extends RecyclerView.Adapter<RenderAdapter.RenderViewHolder> {
    ArrayList<Renter> renters;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListiner;

    public RenderAdapter() {
        ModelDb.openFirebaseDatabase("RentalBike");
        mFirebaseDatabase = ModelDb.mFirebaseDatabase;
        mDatabaseReference = ModelDb.rDatabaseReference;
        renters = ModelDb.renters;
        mChildListiner = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                Renter renter = snapshot.getValue(Renter.class);
                Log.d("Deal" , renter.getNickName());
                renter.setId(snapshot.getKey());
                renters.add(renter);
                notifyItemInserted(renters.size()-1);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDatabaseReference.addChildEventListener(mChildListiner);

    }



    @NonNull
    @Override
    public RenderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.rv_row,parent,false);
        return new RenderViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RenderViewHolder holder, int position) {
        Renter renter = renters.get(position);
        holder.bind(renter);
    }

    @Override
    public int getItemCount() {
        return renters.size();
    }

    public class RenderViewHolder extends RecyclerView.ViewHolder{
        TextView bikeList;
        TextView emailList;
        TextView priceList;


        public RenderViewHolder(@NonNull View itemView) {
            super(itemView);
            bikeList = (TextView) itemView.findViewById(R.id.bikeList);
            emailList = (TextView) itemView.findViewById(R.id.emailList);
            priceList = (TextView) itemView.findViewById(R.id.send);


        }
        public void bind(Renter render){
            bikeList.setText(render.getNickName());
            emailList.setText(render.getEmail());
            priceList.setText((Integer.toString(render.getPrice())));

        }


    }
}
