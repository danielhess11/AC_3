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
                String name = taskName.getText().toString();
                String date = taskDate.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", name);
                resultIntent.putExtra("date", date);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }


}