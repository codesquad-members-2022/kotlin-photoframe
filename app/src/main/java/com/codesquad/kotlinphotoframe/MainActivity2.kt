package com.codesquad.kotlinphotoframe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.d("MainActivity2", "onCreate")

        val button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener{
            finish()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("MainActivity2", "onStart")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("MainActivity2", "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("MainActivity2", "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("MainActivity2", "onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity2", "onDestroy")
    }
}