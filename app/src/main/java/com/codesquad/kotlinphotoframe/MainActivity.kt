package com.codesquad.kotlinphotoframe

import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import java.io.BufferedInputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")
        val name = "Andrew"
        val mainText = findViewById<TextView>(R.id.textView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        mainText.text = "${name}의 사진 액자"

        val button1 = findViewById<TextView>(R.id.button1)
        button1.setOnClickListener{
            Snackbar.make(it, "사진을 불러옵니다.", Snackbar.LENGTH_LONG)
                .show();
            changeButtonText()
            imageView.setImageBitmap(BitmapFactory.decodeStream(BufferedInputStream(resources.assets.open("${getRandomNumber()}.jpg"))))
        }
    }

    private fun getRandomNumber(): Int {
        return (1..22).random()
    }

    private fun changeButtonText() {
        val buttonText = findViewById<TextView>(R.id.button1)
        buttonText.text = "다음"
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
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}