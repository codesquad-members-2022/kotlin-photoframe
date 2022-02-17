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
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")
        val name = "Andrew"
        val mainText = findViewById<TextView>(R.id.textView)
        mainText.text = "${name}의 사진 액자"
        mainText.setTextColor(Color.MAGENTA)
        mainText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)
        mainText.setBackgroundColor(Color.YELLOW)

        val layout: ConstraintLayout = findViewById(R.id.layout)
        val getResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val message = it.data?.getStringExtra("message").toString()
                    Snackbar.make(layout, message, Snackbar.LENGTH_SHORT).show()
                }
            }

        val button1 = findViewById<TextView>(R.id.button1)
        button1.setOnClickListener{
            Snackbar.make(it, "사진을 불러옵니다.", Snackbar.LENGTH_LONG)
                .show();
            changeButtonText()

            button1.setOnClickListener {
                val intent = Intent(this, MainActivity2::class.java)
                getResult.launch(intent)
            }
        }
    }

    fun changeButtonText() {
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