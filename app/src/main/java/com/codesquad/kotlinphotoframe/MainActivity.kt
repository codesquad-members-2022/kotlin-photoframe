package com.codesquad.kotlinphotoframe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","onCreate")

    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity","onStart")
        Toast.makeText(this,"onStart()호출",Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity","reStart")
        Toast.makeText(this,"onRestart()호출",Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        Log.d("MainActivity","onResume")
        Toast.makeText(this,"onResume()호출",Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity","onStop")
        Toast.makeText(this,"onStop()호출",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity","onPause")
        Toast.makeText(this,"onPause()호출",Toast.LENGTH_SHORT).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity","onDestroy")
        Toast.makeText(this,"onDestroy()호출",Toast.LENGTH_SHORT).show()
    }
}