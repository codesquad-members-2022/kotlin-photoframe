package com.codesquad.kotlinphotoframe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")

        val name = "Stitch"
        val textView: TextView = findViewById(R.id.textview_name)
        textView.text = "${name}의 사진 액자"

        val buttonPictureAdd: Button = findViewById(R.id.button_picture_add)
        val layout: ConstraintLayout = findViewById(R.id.constraintlayout_layout)
        buttonPictureAdd.setOnClickListener {
            Snackbar.make(layout, "사진을 불러옵니다.", Snackbar.LENGTH_SHORT).show()
        }
    }
}