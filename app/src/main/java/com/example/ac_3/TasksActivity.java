package com.example.ac_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {

    RecyclerView taskManager;

    FloatingActionButton addTask;

    private TaskAdapter adapter;
    private ArrayList<Task> taskList = new ArrayList<>();

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

        addTask = findViewById(R.id.addTask);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TasksActivity.this, CreateTaskActivity.class);
                startActivityForResult(intent, 1);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                String date = data.getStringExtra("date");

                Task task = new Task(name, date);
                taskList.add(task);
                adapter.notifyDataSetChanged();
            }
        }
    }



}