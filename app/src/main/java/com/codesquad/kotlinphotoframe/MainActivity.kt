package com.codesquad.kotlinphotoframe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate")
        setContentView(R.layout.activity_main)
        val name = "Linus"
        val textForFrame: TextView = findViewById(R.id.textForFrame)
        textForFrame.text = "${name}의 사진액자"
        textForFrame.setTextColor(Color.parseColor("#FF0000"))
        textForFrame.setBackgroundColor(Color.YELLOW)
        textForFrame.setTextSize(5,8.0f)

    }
}