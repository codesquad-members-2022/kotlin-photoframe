package com.codesquad.kotlinphotoframe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_photo_frame)
        Log.d("Main", "onCreate")

        val t = findViewById<TextView>(R.id.photo_frame_header2)
        t.text = "My photoFrame"

    }
}