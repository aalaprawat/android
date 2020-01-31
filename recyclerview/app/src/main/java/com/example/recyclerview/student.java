package com.example.recyclerview;

import android.graphics.Bitmap;

public class student {

    String Name;
    Bitmap photo;
    String date;

    public String getName() {
        return Name;
    }

    public String getDate() {
        return date;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public student(String name, String date, Bitmap photo) {
        Name = name;
        this.date = date;
        this.photo = photo;
    }
}
