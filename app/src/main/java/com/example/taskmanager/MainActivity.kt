package com.example.taskmanager

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var btnAdd : Button


    private lateinit var recyclerView: RecyclerView
    private val tasks = ArrayList<Task>()
    private lateinit var taskAdapter: TaskAdapter
    private val REQUEST_CODE_ADD_TASK = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initAdapter()

        btnAdd.setOnClickListener{
            val intent= Intent(this@MainActivity,SecondActivity::class.java)
            startActivityForResult(intent,1)
        }
//        addTask()

    }

//    privatew fun addTask(task: Task) {
//        tasks.add(task)
//        taskAdapter.notifyItemInserted(tasks.size - 1)
//    }

    private fun initAdapter() {
        taskAdapter = TaskAdapter(tasks)
        recyclerView.adapter = taskAdapter
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        btnAdd = findViewById(R.id.btnAdd)
        recyclerView.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_add) {

            return true;
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

            val category = data?.getStringExtra("category") ?: ""
            val title = data?.getStringExtra("title") ?: ""
            val dueDate = data?.getStringExtra("duedate") ?: ""
            val imageResourceId = data?.getIntExtra("selectedImageIds", 0) ?: 0

            val newTask = Task(category, title, dueDate,imageResourceId)

            // Add the new task to the adapter's data list
            tasks.add(0,newTask)
            taskAdapter.notifyItemInserted(0)
            recyclerView.scrollToPosition(0)
        }
    }

