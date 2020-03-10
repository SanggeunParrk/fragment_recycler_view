package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PFriendMainActivity extends AppCompatActivity {
    PFriendFragment pFragment1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_activity_main);
        pFragment1 = new PFriendFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.mContainer,pFragment1).commit();
    }
}
