package com.example.ip_sham_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ip_sham_android.databinding.ActivityDashboardBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DashboardActivity extends DrawerBaseActivity {

    ActivityDashboardBinding activityDashboardBinding;
    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    TextView temp,hum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(activityDashboardBinding.getRoot());
        allocateActivityTitle("Dashborad");

        temp = findViewById(R.id.temp);
        hum = findViewById(R.id.hum);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final String getTempValue = snapshot.child("detection/temperature/value").getValue(String.class);
                final String getHumValue = snapshot.child("detection/humidity/value").getValue(String.class);
                temp.setText(getTempValue+"°C");
                hum.setText(getHumValue+"%");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DashboardActivity.this, "Something went wrong !"+error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}