package com.example.bikerental.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.bikerental.MainActivity;
import com.example.bikerental.R;
import com.example.bikerental.adapter.RenderAdapter;
import com.example.bikerental.dbModel.ModelDb;
import com.example.bikerental.renterModel.Renter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ArrayList<Renter> renters;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListiner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView rvRenters =(RecyclerView) findViewById(R.id.rvRender);
        final RenderAdapter adapter = new RenderAdapter();
        rvRenters.setAdapter(adapter);
        LinearLayoutManager renderLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL , false);

        rvRenters.setLayoutManager(renderLayoutManager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_ac, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.insert_menu:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            }
        return super.onOptionsItemSelected(item);

    }
}
