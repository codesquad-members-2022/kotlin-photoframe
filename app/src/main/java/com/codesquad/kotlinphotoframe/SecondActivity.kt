package com.codesquad.kotlinphotoframe

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import 	android.content.Intent
import android.graphics.Color
import android.util.Log
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar


class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("SecondActivity", "onCreate")


        val layout = findViewById<ConstraintLayout>(R.id.secondLayOut)
        setLayoutColor(layout)

        val button = findViewById<Button>(R.id.button3)
        setFirstButton(button)
        clickButtonToFinish(button)
    }

    private fun setLayoutColor(layout:ConstraintLayout) {
        layout.setBackgroundColor(Color.parseColor("#FFE42B2B"))
    }

    private fun setFirstButton(button:Button) {
        button.text = "닫기"
        button.setTextColor(Color.BLACK)
        button.setBackgroundColor(Color.YELLOW)
    }

    private fun clickButtonToFinish(button: Button) {
        button.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("SecondActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SecondActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SecondActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SecondActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SecondActivity", "onDestroy")
    }
}