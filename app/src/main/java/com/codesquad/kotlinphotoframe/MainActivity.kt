package com.codesquad.kotlinphotoframe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate")

        val text1 = findViewById<TextView>(R.id.textView1)
        val button1 = findViewById<Button>(R.id.button1)

        text1.text = "사진액자"
        text1.setBackgroundColor(Color.YELLOW)
        text1.setTextColor(Color.GREEN)
        text1.textSize = 41.0F

        button1.setOnClickListener{
            Snackbar.make(button1,"사진을 불러옵니다",5000).show()
        }
    }
}