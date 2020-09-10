package com.example.bikerental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bikerental.dbModel.ModelDb;
import com.example.bikerental.renterModel.Renter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView email;
    private TextView nickName;
    private Button sendButton;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDtabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ModelDb.openFirebaseDatabase("RentalBike");
        mFirebaseDatabase = ModelDb.mFirebaseDatabase;
        mDtabaseReference = ModelDb.rDatabaseReference;
        email = findViewById(R.id.email);
        nickName = findViewById(R.id.nickname);
        sendButton = findViewById(R.id.send);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveInfo();
                clean();

            }
        });


    }

    private void saveInfo(){
        String emailR = email.getText().toString();
        String nickNameR = nickName.getText().toString();
        Random random = new Random();
        int random1 = random.nextInt(3000);
        Renter renter = new Renter(emailR, nickNameR,random1);
        mDtabaseReference.push().setValue(renter);
        Toast.makeText(this, "Save ", Toast.LENGTH_LONG).show();
    }
    private void clean(){
        email.setText("");
        nickName.setText("");

    }


}