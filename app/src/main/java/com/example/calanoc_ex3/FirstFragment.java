// FirstFragment.java
package com.example.calanoc_ex3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    TextView netTextView, roleTextView, grossPayTextView;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        roleTextView = view.findViewById(R.id.default_role_info);
        grossPayTextView = view.findViewById(R.id.default_gross_info);
        netTextView = view.findViewById(R.id.default_net_info);
        return view;
    }

    public void displayResults(String role, double grossPay, double netPay) {
        roleTextView.setText(role);
        grossPayTextView.setText(String.format("%.2f", grossPay));
        netTextView.setText(String.format("%.2f", netPay));
    }
}
