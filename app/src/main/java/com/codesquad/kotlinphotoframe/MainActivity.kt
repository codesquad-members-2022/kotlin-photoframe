package com.codesquad.kotlinphotoframe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate")
        setContentView(R.layout.activity_main)
        //TextView 생성 후 코드 참조
        val textForFrame: TextView = findViewById(R.id.textForFrame)
        textForFrame(textForFrame)
        // button 생성 후 코드 참조
        val button: Button = findViewById(R.id.button)
        val textForbutton = "사진 추가"
        button.text = "$textForbutton"
        button.setOnClickListener {
            Snackbar.make(it, "사진을 불러옵니다", LENGTH_SHORT).setAction("Okay") {
                Toast.makeText(this.applicationContext, "Toast 먹고싶다", Toast.LENGTH_SHORT).show()
            }.show()
        }
    }
}


fun textForFrame(textForFrame: TextView) {
    val name = "Linus"
    textForFrame.text = "${name}의 사진액자"
    textForFrame.setTextColor(Color.parseColor("#FF0000"))
    textForFrame.setBackgroundColor(Color.YELLOW)
    textForFrame.setTextSize(5,8.0f)
}

/*
Button 구현을 하기 위해 따로 최상위 함수로 분리했으나 이상하게 Toast.makeText()에서 자꾸 에러가 발생함. 아무래도 MainActivity 객체를 써서 그런 것 같음
private fun button(button: Button) {
    var main = MainActivity()
    val textForbutton = "사진 추가"
    button.text = "$textForbutton"
    button.setOnClickListener {
        Snackbar.make(it, "사진을 불러옵니다", LENGTH_SHORT).setAction("Okay") {
            Toast.makeText(main.applicationContext, "Toast 먹고싶다", Toast.LENGTH_SHORT).show()
        }.show()
    }
}*/
