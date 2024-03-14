package com.example.taskmanager

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ImageGalleryActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_gallery)


        val img1: ImageView = findViewById(R.id.image1)
        val img2: ImageView = findViewById(R.id.image2)
        val img3: ImageView = findViewById(R.id.image3)
        val img4: ImageView = findViewById(R.id.image4)
        val img5: ImageView = findViewById(R.id.image5)
        val img6: ImageView = findViewById(R.id.image6)
        val img7:ImageView = findViewById(R.id.image7)
        val img8: ImageView = findViewById(R.id.image8)

        img1.setOnClickListener {
            // Return the selected image resource to the MainActivity
            val resultIntent = Intent(this@ImageGalleryActivity,SecondActivity::class.java)
            resultIntent.putExtra("selectedImageResource", R.drawable.img1)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        img2.setOnClickListener {
            // Return the selected image resource to the MainActivity
            val resultIntent = Intent(this@ImageGalleryActivity,SecondActivity::class.java)
            resultIntent.putExtra("selectedImageResource", R.drawable.img2)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        img3.setOnClickListener {
            // Return the selected image resource to the MainActivity
            val resultIntent = Intent(this@ImageGalleryActivity,SecondActivity::class.java)
            resultIntent.putExtra("selectedImageResource", R.drawable.img3)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        img4.setOnClickListener {
            // Return the selected image resource to the MainActivity
            val resultIntent = Intent(this@ImageGalleryActivity,SecondActivity::class.java)
            resultIntent.putExtra("selectedImageResource", R.drawable.img4)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        img5.setOnClickListener {
            // Return the selected image resource to the MainActivity
            val resultIntent = Intent(this@ImageGalleryActivity,SecondActivity::class.java)
            resultIntent.putExtra("selectedImageResource", R.drawable.img5)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        img6.setOnClickListener {
            // Return the selected image resource to the MainActivity
            val resultIntent = Intent(this@ImageGalleryActivity,SecondActivity::class.java)
            resultIntent.putExtra("selectedImageResource", R.drawable.img6)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        img7.setOnClickListener {
            // Return the selected image resource to the MainActivity
            val resultIntent = Intent(this@ImageGalleryActivity,SecondActivity::class.java)
            resultIntent.putExtra("selectedImageResource", R.drawable.img7)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        img8.setOnClickListener {
            // Return the selected image resource to the MainActivity
            val resultIntent = Intent(this@ImageGalleryActivity,SecondActivity::class.java)
            resultIntent.putExtra("selectedImageResource", R.drawable.img8)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}