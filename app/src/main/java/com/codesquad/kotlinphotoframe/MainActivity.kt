package com.codesquad.kotlinphotoframe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    var change = true

    lateinit var tv1 : TextView
    lateinit var btn_change_tv1 : Button
    lateinit var btn_add_photo : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")

        tv1 = findViewById<TextView>(R.id.tv1)
        tv1.text = "Han의 사진 액자"

        setTextViewChangeButton()
        setAddPhotoButton()

    }

    fun setTextViewChangeButton(){
        btn_change_tv1 = findViewById(R.id.btn_change_tv1)
        btn_change_tv1.setOnClickListener {
            if(change){
                tv1.apply {
                    text = "CHANGE CLICKED"
                    setTextColor(ContextCompat.getColor(context, R.color.myGreen))
                    setBackgroundResource(R.color.myGray)
                }
                btn_change_tv1.text = "UNDO"
            }
            else{
                tv1.apply {
                    text = "Han의 사진 액자"
                    setTextColor(ContextCompat.getColor(context, R.color.black))
                    setBackgroundColor(ContextCompat.getColor(context, R.color.white))
                }
                btn_change_tv1.text = "CHANGE"
            }
            change = !change
        }
    }

    fun setAddPhotoButton(){
        btn_add_photo = findViewById(R.id.btn_add_photo)
        btn_add_photo.setOnClickListener {
            val snackBar = Snackbar.make(it, "사진을 불러옵니다",Snackbar.LENGTH_SHORT)
            snackBar.show()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart")
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

