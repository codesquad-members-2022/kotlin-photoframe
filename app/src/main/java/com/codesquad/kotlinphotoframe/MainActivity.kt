package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.Dimension
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    var activityName = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val photoFrameTv = findViewById<TextView>(R.id.tv_photoframe)
        val name = "Hede"
        photoFrameTv.text = "${name}의 사진액자"
        photoFrameTv.setBackgroundColor(Color.LTGRAY)
        photoFrameTv.setTextColor(Color.BLUE)
        photoFrameTv.setTextSize(Dimension.SP, 18F)
        val addPhotoBtn = findViewById<Button>(R.id.btn_photoframe)
        /*
        addPhotoBtn.setOnClickListener{
            var snackBar= Snackbar.make(const_layout,"사진을 불러옵니다", Snackbar.LENGTH_LONG)
            snackBar.show()
        }
         */
        addPhotoBtn.text = "다음"
        addPhotoBtn.setOnClickListener {
            var intent: Intent = Intent(this, targetActivity::class.java)
            startActivityForResult(intent, 3000)
        }
        Log.d("${activityName}", "onCreate")

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 3000) {
            var const_layout = findViewById<ConstraintLayout>(R.id.const_layout)
            var message = data!!.getStringExtra("message")
            Snackbar.make(const_layout, "${message}", Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("${activityName}", "onStart")
        //Toast.makeText(this, "onStart()호출", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("${activityName}", "reStart")
        //Toast.makeText(this, "onRestart()호출", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("${activityName}", "onResume")
        //Toast.makeText(this, "onResume()호출", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("${activityName}", "onStop")
        //Toast.makeText(this, "onStop()호출", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("${activityName}", "onPause")
        //Toast.makeText(this, "onPause()호출", Toast.LENGTH_SHORT).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("${activityName}", "onDestroy")
        //Toast.makeText(this, "onDestroy()호출", Toast.LENGTH_SHORT).show()
    }
}