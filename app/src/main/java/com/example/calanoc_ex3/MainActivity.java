// MainActivity.java
package com.example.calanoc_ex3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ABC Job Sourcing");

        // Add this code to directly display both fragments
        if (savedInstanceState == null) {
            loadFragments();
        }
    }

    private void loadFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        // Replace the container with the FirstFragment
        FirstFragment firstFragment = new FirstFragment();
        fragmentTransaction.replace(R.id.fragmentFirstContainer, firstFragment);

        // Replace the container with the SecondFragment
        SecondFragment secondFragment = new SecondFragment();
        fragmentTransaction.replace(R.id.fragmentSecondContainer, secondFragment);
        // Commit the transaction
        fragmentTransaction.commit();
    }

    // Add this method to update FirstFragment with the computed values
    public void updateFirstFragment(String role, double grossPay, double netPay) {
        FirstFragment firstFragment = (FirstFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentFirstContainer);
        if (firstFragment != null) {
            firstFragment.displayResults(role, grossPay, netPay);
        }
    }
}
