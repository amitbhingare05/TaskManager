package com.example.taskmanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.recyclerview.widget.RecyclerView


class TaskAdapter(
    private val taskList : ArrayList<Task>
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imgdeault : ImageView
        val edtTextCategory : TextView
        val edtTextTitle : TextView
        val edtduedate : TextView



        init {
            imgdeault = view.findViewById(R.id.imgdeault)
            edtTextCategory = view.findViewById(R.id.edtTextCategory)
            edtTextTitle = view.findViewById(R.id.edtTextTitle)
            edtduedate = view.findViewById(R.id.edtduedate)
        }
    }

//    fun addTask(task: Task) {
//        taskList.add(task)
//        notifyItemInserted(taskList.size - 1)
//    }

    override fun getItemCount() = taskList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.task_view, parent,false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.imgdeault.setImageResource(task.imageResourceId)
        holder.edtTextTitle.setText("Title : ${task.title}")
        holder.edtTextCategory.setText("Category : ${task.category}")
        holder.edtduedate.setText("Date : ${task.dueDate}")
    }
}