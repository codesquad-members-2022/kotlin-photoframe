package com.codesquad.kotlinphotoframe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate")

        val name = "Stitch"
        val textView: TextView = findViewById(R.id.textview_name)
        textView.text = "${name}의 사진 액자"

        val buttonPictureAdd: Button = findViewById(R.id.button_picture_add)
        val layout: ConstraintLayout = findViewById(R.id.constraintlayout_layout)

        val getResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val message = it.data?.getStringExtra("message").toString()
                    Snackbar.make(layout, message, Snackbar.LENGTH_SHORT).show()
                }
            }

        buttonPictureAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            getResult.launch(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity - onStart() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "MainActivity - onRestart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity - onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity - onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainActivity - onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity - onDestroy() called")
    }
}