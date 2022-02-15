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
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial
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
        val button: Button = findViewById(R.id.button)
        val contextView = findViewById<View>(R.id.context)
        val switch: SwitchMaterial = findViewById(R.id.darkMode)
        switch.text = "dark"
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            when(isChecked){
                true -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
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