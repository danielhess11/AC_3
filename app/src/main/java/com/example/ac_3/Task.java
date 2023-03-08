package com.example.ac_3;

public class Task {

    private String name;
    private String date;

    private boolean checked;

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Task(String name, String date) {
        this.name = name;
        this.date = date;
        this.checked = false;
    }
}
