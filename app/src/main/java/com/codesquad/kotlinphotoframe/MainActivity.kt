package com.codesquad.kotlinphotoframe

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate")
        val text: TextView = findViewById(R.id.name)
        val name = "Funny"
        text.text = "${name}의 사진 액자"
        text.setTextColor(Color.parseColor("#3d00e0"))
        val back: LinearLayout = findViewById(R.id.back)
        back.setBackgroundColor(Color.parseColor("#ffffff"))
        val button: Button = findViewById(R.id.button)
        val contextView = findViewById<View>(R.id.context)
        if (intent.getStringExtra("msg") != null){
            Snackbar.make(contextView, intent.getStringExtra("msg")!!, Snackbar.LENGTH_SHORT).show()
        }
        button.setOnClickListener {
            Log.d("click", "ok")
            val secondIntent = Intent(this, SecondActivity::class.java)
            startActivity(secondIntent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        val activityName = this.localClassName
        val callbackName = "onRestart"
        Log.d("$activityName", "$callbackName")
    }

    override fun onStart() {
        super.onStart()
        val activityName = this.localClassName
        val callbackName = "onStart"
        Log.d("$activityName", "$callbackName")
    }

    override fun onResume() {
        val activityName = this.localClassName
        val callbackName = "onResume"
        Log.d("$activityName", "$callbackName")
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
        val activityName = this.localClassName
        val callbackName = "onStop"
        Log.d("$activityName", "$callbackName")
    }

    override fun onPause() {
        super.onPause()
        val activityName = this.localClassName
        val callbackName = "onPause"
        Log.d("$activityName", "$callbackName")
    }
}