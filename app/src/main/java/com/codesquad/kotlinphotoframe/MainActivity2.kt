package com.codesquad.kotlinphotoframe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.d("MainActivity2", "onStart")

        val button : Button = findViewById(R.id.button)
        button.setOnClickListener{
            val intent = Intent()
            intent.putExtra("message", "사진을 불러왔습니다!!!")
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity2", "onStart")
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