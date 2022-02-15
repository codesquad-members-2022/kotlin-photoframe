package com.codesquad.kotlinphotoframe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        var const_layout = findViewById<ConstraintLayout>(R.id.const_layout)

        var button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.sub_button)
        button.text = "닫기"
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f)
        button.setOnClickListener {
            finish()
        }
    }
}