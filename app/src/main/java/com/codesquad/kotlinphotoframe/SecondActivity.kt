package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "SecondActivity"

class SecondActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d(TAG, "onCreate")
        val picture = findViewById<ImageView>(R.id.my_photo_image_load)
        val frameView = findViewById<ImageView>(R.id.my_photo_frame_second_activity)
        val fab = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fab_second_activity)
        val button: Button = findViewById(R.id.add_photo_button)
        val frameFile = resources.assets.open("photo_frame/photoframe-border.png")
        val frameImage = BitmapFactory.decodeStream(frameFile)
        frameView.setImageBitmap(frameImage)
        frameFile.close()

        val startForResult =
            registerForActivityResult(ActivityResultContracts.GetContent()) {
                val bitmap =
                    ImageDecoder.decodeBitmap(ImageDecoder.createSource(contentResolver, it))
                picture.setImageBitmap(bitmap)
            }

        button.setOnClickListener {
            startForResult.launch("image/*")
        }

        fab.setOnClickListener {
            finish()
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
        Log.d(TAG, "onDestory")
    }

}