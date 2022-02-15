package com.codesquad.kotlinphotoframe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.d("MainActivity2", "onStart")
    }

    fun goBefore(view: View) {
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity2", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity2", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity2", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity2", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity2", "onDestroy")
    }
}