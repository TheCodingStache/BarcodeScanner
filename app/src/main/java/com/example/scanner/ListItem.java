package com.example.scanner;

public class ListItem {
    private int id;
    String code;
    String type;

    public ListItem(int id, String code, String type) {
        this.id = id;
        this.code = code;
        this.type = type;

    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public ListItem() {

    }
}
