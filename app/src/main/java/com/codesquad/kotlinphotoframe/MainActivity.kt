package com.codesquad.kotlinphotoframe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var myTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate")

        myTextView = findViewById(R.id.mainText) // UI 요소를 사용 시 보통 lateinit 을 사용해 객체를 선언하면 좋다.
        myTextView.text = "Stark의 사진액자"
        myTextView.setTextColor(Color.BLUE) // 텍스트 색깔이나 사이즈를 xml 이 아니라 코틀린 코드에서 동적으로 처리하는 이유?
        myTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)
    }
}