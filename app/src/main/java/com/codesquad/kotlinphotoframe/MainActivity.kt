package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")

        val name = "Andrew"
        val mainText = findViewById<TextView>(R.id.textView)
        mainText.text = "${name}의 사진 액자"
        mainText.setTextColor(Color.MAGENTA)
        mainText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)
        mainText.setBackgroundColor(Color.YELLOW)

    }

    fun viewMessage(view: View) {
        Snackbar.make(view, "사진을 불러옵니다.", Snackbar.LENGTH_LONG)
            .show();

        val text2 = findViewById<TextView>(R.id.button1)
        text2.text = "다음"
        setNextButton()
    }

    fun setNextButton() {
        val button: Button = findViewById(R.id.button1)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
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
        val parentLayout = findViewById<View>(android.R.id.content)
        Snackbar.make(parentLayout, "사진을 불러 왔습니다!!", Snackbar.LENGTH_LONG)
            .show();
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}