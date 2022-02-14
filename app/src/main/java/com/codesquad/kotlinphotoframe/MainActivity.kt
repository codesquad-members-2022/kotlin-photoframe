package com.codesquad.kotlinphotoframe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mainText = findViewById<TextView>(R.id.textView)
        mainText.setText("Andrew의 사진 액자")
        mainText.setTextColor(Color.MAGENTA)
        mainText.setTextSize(30f)
        mainText.setBackgroundColor(Color.YELLOW)

        Log.d("MainActivity", "onCreate")
    }
}