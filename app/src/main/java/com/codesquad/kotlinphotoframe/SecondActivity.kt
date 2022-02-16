package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val button: Button = findViewById(R.id.add_photo_button)

        button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}