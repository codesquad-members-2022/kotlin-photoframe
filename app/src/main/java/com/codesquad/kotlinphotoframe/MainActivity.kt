package com.codesquad.kotlinphotoframe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_photo_frame)
        Log.d("Main", "onCreate")

        val button: Button = findViewById(R.id.add_photo_button)

        button.setOnClickListener{
            Snackbar.make(
                findViewById(R.id.custom_layout),
                "사진 불러오는중",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }
}