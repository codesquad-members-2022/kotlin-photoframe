package com.codesquad.kotlinphotoframe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate")
        val text: TextView = findViewById(R.id.name)
        val name = "Funny"
        text.text = "${name}의 사진 액자"
        text.setTextColor(Color.parseColor("#3d00e0"))
        val back: LinearLayout = findViewById(R.id.back)
        back.setBackgroundColor(Color.parseColor("#ffffff"))
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
        Toast.makeText(applicationContext, "사진을 불러오는 중입니다.", Toast.LENGTH_SHORT).show()
        }
    }
}