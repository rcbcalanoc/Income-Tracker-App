package com.example.calanoc_ex3;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ABC Job Sourcing");

        // Add this code to directly display the SecondFragment
        if (savedInstanceState == null) {
            loadSecondFragment();
        }
    }

    private void loadSecondFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the container with the SecondFragment
        SecondFragment secondFragment = new SecondFragment();
        fragmentTransaction.replace(R.id.fragment_container, secondFragment);

        // Commit the transaction
        fragmentTransaction.commit();
    }
}
