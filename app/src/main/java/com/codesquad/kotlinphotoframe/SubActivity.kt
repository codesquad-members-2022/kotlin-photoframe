package com.codesquad.kotlinphotoframe

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        var button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.sub_button)
        button.text = "닫기"
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f)
        button.setOnClickListener {
            val returnIntent = Intent(this, MainActivity::class.java) //MainActivity 에 대한 intent 를 생성해 putExtra 로 데이터를 담
            returnIntent.putExtra("message", "사진을 불러옵니다.")
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}