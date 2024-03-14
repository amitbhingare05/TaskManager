package com.example.taskmanager

import android.app.Activity
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {

    private lateinit var editTextCategory: EditText
    private lateinit var editTextTitle: EditText
    private lateinit var btnsaved: Button

    private val REQUEST_CODE_SELECT_IMAGE = 3
    private lateinit var imgdeaulticon: ImageView

    private lateinit var editduedate: EditText

    private lateinit var imagebuttondatepicker: ImageButton

    private val tasksList = ArrayList<Task>()
    private lateinit var taskAdapter: TaskAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        editTextCategory = findViewById(R.id.editTextCategory)
        editTextTitle = findViewById(R.id.editTextTitle)
        btnsaved = findViewById(R.id.btnsaved)
        imgdeaulticon = findViewById(R.id.imgdeaulticon)
        imagebuttondatepicker = findViewById(R.id.imagebuttondatepicker)
        editduedate = findViewById(R.id.editduedate)

        imgdeaulticon.setImageResource(R.drawable.img1)

        initListner()


        // Retrieve the selected date from the intent from datepickeractivity
        val selectedDate = intent.getStringExtra("Selected date")

        editduedate.setText(selectedDate)

    }

    private fun initListner() {
        imgdeaulticon.setOnClickListener {
            val intent = Intent(this@SecondActivity, ImageGalleryActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_SELECT_IMAGE)
        }


        imagebuttondatepicker.setOnClickListener {
            val datePickerDialog =
                DatePickerDialog(this@SecondActivity, MyOnDateSetListener(), 2024, 1, 9)
            datePickerDialog.show()
        }


    }



       private inner class MyOnDateSetListener : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                editduedate.setText("$dayOfMonth - ${month + 1} - $year")
            }
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == REQUEST_CODE_SELECT_IMAGE && resultCode == RESULT_OK) {
                val selectedImageResource = data?.getIntExtra("selectedImageResource", 0)

                // Check if a valid image resource is received
                if (selectedImageResource != null && selectedImageResource != 0) {
                    imgdeaulticon.setImageResource(selectedImageResource)

                    btnsaved.setOnClickListener {
                        val category = findViewById<EditText>(R.id.editTextCategory).text.toString()
                        val title = findViewById<EditText>(R.id.editTextTitle).text.toString()
                        val dueDate = findViewById<EditText>(R.id.editduedate).text.toString()
                        val imageResourceId = imgdeaulticon.tag as? Int ?: 0


                        val intent = Intent()
                        intent.putExtra("selectedImageIds", selectedImageResource)
                        intent.putExtra("title", title)
                        intent.putExtra("duedate", dueDate)
                        intent.putExtra("category", category)
                        setResult(1, intent)
                        finish()


                    }
                }
            }
        }
    }
