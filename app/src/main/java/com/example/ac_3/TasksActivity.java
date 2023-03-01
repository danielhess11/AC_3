package com.example.ac_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {

    RecyclerView taskManager;

    private TaskAdapter adapter;
    private ArrayList<Task> taskList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        Intent previous = getIntent();

        String name = previous.getStringExtra("name");
        String date = previous.getStringExtra("date");

        taskManager = findViewById(R.id.taskManager);

        taskManager.setLayoutManager(new LinearLayoutManager(this));
        taskList = new ArrayList<>();
        adapter = new TaskAdapter(this, taskList);
        taskManager.setAdapter(adapter);
        taskManager.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        Task task = new Task(name, date);
        taskList.add(task);

    }
}