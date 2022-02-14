package com.codesquad.kotlinphotoframe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SecondActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val closeButton: Button = findViewById(R.id.button_close)
        closeButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("message", "사진을 불러왔습니다")
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "SecondActivity - onStart() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "SecondActivity - onRestart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "SecondActivity - onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "SecondActivity - onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "SecondActivity - onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SecondActivity - onDestroy() called")
    }
}