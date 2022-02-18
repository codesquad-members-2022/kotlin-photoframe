package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial


class MainActivity : AppCompatActivity() {
    fun String.Snackbar(contextView: View, intent: Intent) {
        Snackbar.make(contextView, this, Snackbar.LENGTH_SHORT).show()
    }
    private lateinit var activityName: String
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
            when (isChecked) {
                true -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        val msg = intent.getStringExtra("msg")
        msg?.Snackbar(contextView, intent)
        intent.removeExtra("msg")
        val imageView: ImageView = findViewById(R.id.image_view)
        imageView.setBackgroundColor(Color.GRAY)
        button.setOnClickListener {
//            val secondIntent = Intent(this, SecondActivity::class.java)
//            startActivity(secondIntent)
            imageLoad(imageView)
        }
    }

    fun imageLoad(imageView: ImageView) {
        val fileName = makeFileName((1..22).random())

        //step 1. asset 폴더에서 파일 열기
        val image = resources.assets.open("$fileName.jpg")
        val bitmap = BitmapFactory.decodeStream(image)

        //step 2. imageView에 표시
        imageView.setImageBitmap(bitmap)
    }

    fun makeFileName(fileName: Int) = when (fileName / 10 == 0) {
        true -> "0$fileName"
        else -> fileName.toString()
    }

    override fun onRestart() {
        super.onRestart()
        activityName = this.localClassName
        val callbackName = "onRestart"
        Log.d("$activityName", "$callbackName")
    }

    override fun onStart() {
        super.onStart()
        activityName = this.localClassName
        val callbackName = "onStart"
        Log.d("$activityName", "$callbackName")
    }

    override fun onResume() {
        activityName = this.localClassName
        val callbackName = "onResume"
        Log.d("$activityName", "$callbackName")
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
        activityName = this.localClassName
        val callbackName = "onStop"
        Log.d("$activityName", "$callbackName")
    }

    override fun onPause() {
        super.onPause()
        activityName = this.localClassName
        val callbackName = "onPause"
        Log.d("$activityName", "$callbackName")
    }
}