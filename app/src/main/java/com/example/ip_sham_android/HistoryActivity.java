package com.example.ip_sham_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.ip_sham_android.databinding.ActivityHistoryBinding;

public class HistoryActivity extends DrawerBaseActivity {

    ActivityHistoryBinding activityHistoryBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHistoryBinding = ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(activityHistoryBinding.getRoot());
        allocateActivityTitle("History");
        replaceFragment(new TempFragment());


        activityHistoryBinding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.botTem:
                    replaceFragment(new TempFragment());
                    allocateActivityTitle("Temperature History");
                    break;
                case R.id.botHum:
                    replaceFragment(new HumFragment());
                    allocateActivityTitle("Humidity History");
                    break;
                case R.id.botSmk:
                    replaceFragment(new SmokeFragment());
                    allocateActivityTitle("Smoke History");
                    break;
                case R.id.botFlame:
                    replaceFragment(new FlameFragment());
                    allocateActivityTitle("Flame History");
                    break;
            }
            return  true;
        });
    }

    private  void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}