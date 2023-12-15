package com.example.calanoc_ex3;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomSpinnerAdapter extends BaseAdapter {

    private Context context;
    private List<SpinnerItem> spinnerItemList;

    public CustomSpinnerAdapter(Context context, List<SpinnerItem> spinnerItemList) {
        this.context = context;
        this.spinnerItemList = spinnerItemList;
    }

    @Override
    public int getCount() {
        return spinnerItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return spinnerItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.custom_spinner_item, parent, false);
        }

        ImageView imageView = view.findViewById(R.id.spinnerItemImageView);
        TextView textView = view.findViewById(R.id.spinnerItemTextView);

        SpinnerItem spinnerItem = spinnerItemList.get(position);
        imageView.setImageResource(spinnerItem.getImageResource());
        textView.setText(spinnerItem.getText());

        return view;
    }
}
