package com.codesquad.kotlinphotoframe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")

        val tvExplain: TextView = findViewById(R.id.tv_explain)
        tvExplain.text = "wooki의 사진 액자^^"
        tvExplain.setTextColor(Color.RED)
        tvExplain.setBackgroundColor(Color.YELLOW)
        tvExplain.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24F)
    }
}
