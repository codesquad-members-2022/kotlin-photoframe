package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate")

        val tvExplain: TextView = findViewById(R.id.tv_explain)
        tvExplain.text = "wooki의 사진 액자^^"
        tvExplain.setTextColor(Color.RED)
        tvExplain.setBackgroundColor(Color.YELLOW)
        tvExplain.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24F)

        val btnAddImage: Button = findViewById(R.id.btn_add_image)
        val layoutMain: View = findViewById(R.id.layout_main)
        btnAddImage.setOnClickListener {
            Snackbar.make(layoutMain, "사진을 불러옵니다.", Snackbar.LENGTH_SHORT).show()
            val intent = Intent(this, PhotoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart")
        super.onRestart()
    }
}
