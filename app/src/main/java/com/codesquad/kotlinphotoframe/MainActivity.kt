package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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
        text1.textSize = 42.0F

        button1.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
            Snackbar.make(button1,"사진을 불러옵니다",5000).show()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}