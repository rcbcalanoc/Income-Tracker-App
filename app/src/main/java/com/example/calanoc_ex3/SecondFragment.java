package com.example.calanoc_ex3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView;
import android.widget.Toast;

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

        return view;
    }

    private CustomSpinnerAdapter createCustomSpinnerAdapter() {
        // Create a list of SpinnerItems
        List<SpinnerItem> spinnerItemList = new ArrayList<>();
        spinnerItemList.add(new SpinnerItem(R.drawable.programmer, "Programmer"));
        spinnerItemList.add(new SpinnerItem(R.drawable.analyst, "Analyst"));
        spinnerItemList.add(new SpinnerItem(R.drawable.tester, "Tester"));

        // Add more items as needed

        // Create and return the custom adapter
        return new CustomSpinnerAdapter(requireContext(), spinnerItemList);
    }
}

