package com.codesquad.kotlinphotoframe

import android.content.Intent
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
            Log.d("click", "ok")
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        val activityName = this.localClassName
        val callbackName = "onRestart"
        Log.d("$activityName", "$callbackName")
    }

    override fun onStart() {
        super.onStart()
        val activityName = this.localClassName
        val callbackName = "onStart"
        Log.d("$activityName", "$callbackName")
        Toast.makeText(applicationContext, "사진을 불러오는 중입니다.", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        val activityName = this.localClassName
        val callbackName = "onResume"
        Log.d("$activityName", "$callbackName")
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
        val activityName = this.localClassName
        val callbackName = "onStop"
        Log.d("$activityName", "$callbackName")
    }

    override fun onPause() {
        super.onPause()
        val activityName = this.localClassName
        val callbackName = "onPause"
        Log.d("$activityName", "$callbackName")
    }
}