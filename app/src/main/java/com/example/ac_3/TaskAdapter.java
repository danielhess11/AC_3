package com.example.ac_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder>{

    private Context context;
    private ArrayList<Task> tasks;

    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }


    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.task_layout, parent, false);

        return new TaskHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskHolder holder, int position) {
        Task task = tasks.get(position);
        holder.setDetails(task);

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = holder.checkBox.isChecked();
                task.setChecked(checked);
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasks.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, tasks.size());
            }
        });

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    class TaskHolder extends RecyclerView.ViewHolder {

        public TextView taskNameS, taskDateS;
        public CheckBox checkBox;
        public Button deleteButton;
        public TaskHolder(@NonNull View itemView) {
            super(itemView);
            taskNameS = itemView.findViewById(R.id.taskNameS);
            taskDateS = itemView.findViewById(R.id.taskDateS);
            checkBox = itemView.findViewById(R.id.checkBox);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }

        void setDetails(Task task) {
            taskNameS.setText(task.getName());
            taskDateS.setText(task.getDate());
            checkBox.setChecked(task.isChecked());
        }
    }
}
