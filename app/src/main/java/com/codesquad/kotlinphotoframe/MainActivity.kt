package com.codesquad.kotlinphotoframe

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import java.io.BufferedInputStream

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val IMAGE_NUMBER = 22
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate")

        val name = "Stitch"
        val textView: TextView = findViewById(R.id.textview_name)
        textView.text = "${name}의 사진 액자"

        val buttonPictureAdd: Button = findViewById(R.id.button_picture_add)
        val layout: ConstraintLayout = findViewById(R.id.constraintlayout_layout)
        val photo: ImageView = findViewById(R.id.imageview_photo)
        buttonPictureAdd.setOnClickListener {
            changeImage(layout, photo, getRandomNumber(IMAGE_NUMBER))
        }
    }

    private fun changeImage(layout: ConstraintLayout, photo: ImageView, imageName: String) {
        photo.setImageBitmap(BitmapFactory.decodeStream(BufferedInputStream(resources.assets.open("${imageName}.jpg"))))
    }

    private fun getRandomNumber(number: Int): String {
        val randomNumber = (1..number).random().toString()
        return if(randomNumber.length != 1) randomNumber else "0$randomNumber"
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity - onStart() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "MainActivity - onRestart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity - onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity - onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainActivity - onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity - onDestroy() called")
    }
}