package com.codesquad.kotlinphotoframe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mainText = findViewById<TextView>(R.id.textView)
        mainText.setText("Andrew의 사진 액자")
        mainText.setTextColor(Color.MAGENTA)
        mainText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)
        mainText.setBackgroundColor(Color.YELLOW)

    }

    fun viewMessage(view: View) {
        Snackbar.make(view, "사진을 불러옵니다.", Snackbar.LENGTH_LONG)
            .show();
    }
}