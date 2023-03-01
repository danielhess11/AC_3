package com.example.ac_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
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



        taskManager = findViewById(R.id.taskManager);

        taskManager.setLayoutManager(new LinearLayoutManager(this));
        taskList = new ArrayList<>();
        adapter = new TaskAdapter(this, taskList);
        taskManager.setAdapter(adapter);
        taskManager.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        createList();
    }

    private void createList() {
        Task task = new Task("something", "sometime");
        taskList.add(task);
    }
}