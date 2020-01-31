package com.example.customdynamiclistview;



public class person {
    String name;
    int photo;

    public String getName() {
        return name;
    }

    public int getPhoto() {
        return photo;
    }

    public int getCross() {
        return cross;
    }

    public person(String name, int photo, int cross) {
        this.name = name;
        this.photo = photo;
        this.cross = cross;
    }

    int cross;

}
