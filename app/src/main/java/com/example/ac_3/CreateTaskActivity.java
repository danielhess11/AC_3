package com.example.ac_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateTaskActivity extends AppCompatActivity {

    EditText taskName, taskDate;
    Button saveTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        taskName = findViewById(R.id.nameTask);
        taskDate = findViewById(R.id.dateTask);
        saveTask = findViewById(R.id.saveTask);
        saveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String taskNameS = taskName.getText().toString();
                String taskDateS = taskDate.getText().toString();

                Intent next = new Intent(CreateTaskActivity.this, TasksActivity.class);
                next.putExtra("name", taskNameS);
                next.putExtra("date", taskDateS);
                startActivity(next);
            }
        });
    }
}