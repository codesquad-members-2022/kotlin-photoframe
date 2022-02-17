package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_frame)
        Log.d(TAG, "onCreate")

        val layout = findViewById<ConstraintLayout>(R.id.custom_layout)
        val button: Button = findViewById(R.id.next_photo_button)
        val imageView = findViewById<ImageView>(R.id.my_photo_image)

        button.setOnClickListener {
            Snackbar.make(
                layout,
                "사진을 불러왔습니다",
                Snackbar.LENGTH_LONG
            ).show()

            val randomNum = (1..22).random()
            val randomID = if (randomNum < 10) {
                "0$randomNum"
            } else {
                randomNum.toString()
            }

            val rawFile = resources.assets
            val sourceImage = rawFile?.open("pictures/$randomID.jpg")
            sourceImage?.run {
                val bitmapImage = BitmapFactory.decodeStream(this)
                imageView.setImageBitmap(bitmapImage)
            } ?: run {
                Snackbar.make(
                    layout,
                    "사진이 존재하지 않습니다",
                    Snackbar.LENGTH_LONG
                ).show()
            }
            sourceImage?.close()
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

}