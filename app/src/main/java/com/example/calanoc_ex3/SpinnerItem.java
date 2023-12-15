package com.example.calanoc_ex3;
public class SpinnerItem {
    private int imageResource;
    private String text;

    public SpinnerItem(int imageResource, String text) {
        this.imageResource = imageResource;
        this.text = text;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText() {
        return text;
    }
}
