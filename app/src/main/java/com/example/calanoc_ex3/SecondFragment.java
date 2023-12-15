package com.example.calanoc_ex3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        // Find the Spinner in the layout
        CustomSpinnerAdapter customSpinnerAdapter = createCustomSpinnerAdapter();
        Spinner customSpinner = view.findViewById(R.id.custom_spinner);
        customSpinner.setAdapter(customSpinnerAdapter);

        // Set item click listener for the Spinner
        customSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Handle item selection here
                SpinnerItem selectedSpinnerItem = (SpinnerItem) parentView.getItemAtPosition(position);
                Toast.makeText(requireContext(), "Selected: " + selectedSpinnerItem.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        // Set click listener for the submit button
        view.findViewById(R.id.submit_form).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplayResults(view);
            }
        });

        return view;
    }

    private CustomSpinnerAdapter createCustomSpinnerAdapter() {
        // Create a list of SpinnerItems
        List<SpinnerItem> spinnerItemList = new ArrayList<>();
        spinnerItemList.add(new SpinnerItem(R.drawable.programmer, "Programmer"));
        spinnerItemList.add(new SpinnerItem(R.drawable.analyst, "Analyst"));
        spinnerItemList.add(new SpinnerItem(R.drawable.tester, "Tester"));

        return new CustomSpinnerAdapter(requireContext(), spinnerItemList);
    }
    private double calculateGrossPay(double hoursWorked) {
        // Implement your logic to calculate gross pay based on role and hours worked
        // This is just a placeholder, you need to replace it with your actual calculation
        return 1000.0 * hoursWorked;
    }

    private double calculateNetPay(double grossPay, int dependents) {
        // Implement the correct logic to calculate net pay based on gross pay and number of dependents
        double incomeTaxDeduction = (grossPay - (grossPay * 0.05 * dependents)) * 0.15;
        return grossPay - incomeTaxDeduction;
    }
    private void calculateAndDisplayResults(View view) {
        // Retrieve user input
        String role = ((Spinner) view.findViewById(R.id.custom_spinner)).getSelectedItem().toString();
        int dependents = Integer.parseInt(((EditText) view.findViewById(R.id.edit_dependent)).getText().toString());
        double hoursWorked = Double.parseDouble(((EditText) view.findViewById(R.id.edit_hours_work)).getText().toString());

        // Perform computation
        double grossPay = calculateGrossPay(hoursWorked);
        double netPay = calculateNetPay(grossPay, dependents);

        // Pass results to MainActivity to update FirstFragment
        MainActivity mainActivity = (MainActivity) requireActivity();
        mainActivity.updateFirstFragment(role, grossPay, netPay);
    }



}
