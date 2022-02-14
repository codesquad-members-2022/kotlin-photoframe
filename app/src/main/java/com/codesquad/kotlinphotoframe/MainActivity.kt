package com.codesquad.kotlinphotoframe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    var change = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")

        val tv1 = findViewById<TextView>(R.id.tv1)
        tv1.text = "Han의 사진 액자"

        val btn_change_tv1 = findViewById<Button>(R.id.btn_change_tv1)
        btn_change_tv1.setOnClickListener {
            if(change){
                tv1.apply {
                    text = "CHANGE CLICKED"
                    setTextColor(ContextCompat.getColor(context, R.color.myGreen))
                    setBackgroundResource(R.color.myGray)
                }
            }
            else{
                tv1.apply {
                    text = "Han의 사진 액자"
                    setTextColor(ContextCompat.getColor(context, R.color.black))
                    setBackgroundColor(ContextCompat.getColor(context, R.color.white))
                }
            }
            change = !change
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

