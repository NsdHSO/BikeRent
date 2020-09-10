package com.example.bikerental.dbModel;

import com.example.bikerental.renterModel.Renter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ModelDb {
    public static FirebaseDatabase mFirebaseDatabase;
    public static DatabaseReference rDatabaseReference;
    private static ModelDb modelDb;
    public static ArrayList<Renter> renters;
    private ModelDb () {}
    public static void openFirebaseDatabase(String ref){
        if (modelDb == null){
            modelDb = new ModelDb();
            mFirebaseDatabase = FirebaseDatabase.getInstance();
            renters = new ArrayList<>();
        }
        rDatabaseReference = mFirebaseDatabase.getReference().child(ref);
    }
}
