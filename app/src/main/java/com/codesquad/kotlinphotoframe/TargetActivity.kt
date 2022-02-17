package com.codesquad.kotlinphotoframe

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class TargetActivity : AppCompatActivity() {
    val tag = "TargetActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target)
        val prevBtn = findViewById<Button>(R.id.target_btn_select)
        prevBtn.setOnClickListener {
            var intent = intent
            intent.putExtra("message", "사진을 불러왔습니다")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        Log.d("${tag}", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("$tag", "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d("$tag", "onStop")
    }

    override fun onPause() {
        super.onPause()
        Log.d("$tag", "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("$tag", "onDestroy")
    }

}