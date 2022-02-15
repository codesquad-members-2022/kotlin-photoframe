package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.Dimension
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    var tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //2단계 textView 구현하기
        val photoFrameTv = findViewById<TextView>(R.id.tv_photoframe)
        val name ="Hede"
        photoFrameTv.text = "${name}의 사진액자"
        //photoFrameTv.setText("abc")
        photoFrameTv.setBackgroundColor(Color.parseColor("#FF000000"))
        photoFrameTv.setBackgroundColor(Color.LTGRAY)
        photoFrameTv.setTextColor(Color.BLUE)
        photoFrameTv.setTextColor(Color.parseColor("#FF000000"))
        var color= ContextCompat.getColor(this, R.color.your_color)
        photoFrameTv.setTextColor(color)
        photoFrameTv.setTextSize(Dimension.SP, 18F)
        photoFrameTv.setTextSize(Dimension.DP, 16F)
    //    photoFrameTv.setTextSize(16F)
        photoFrameTv.textSize=16F
//        val addPhotoBtn = findViewById<Button>(R.id.btn_photoframe)
//        /*
//        3단계 Button 추가하기 + Button Event 처리
//        addPhotoBtn.setOnClickListener{
//            var snackBar= Snackbar.make(const_layout,"사진을 불러옵니다", Snackbar.LENGTH_LONG)
//            snackBar.show()
//        }
//         */
//        addPhotoBtn.text = "다음"
//        addPhotoBtn.setOnClickListener {
//            var intent: Intent = Intent(this, targetActivity::class.java)
//            startActivityForResult(intent, 3000)
//        }
        Log.d("$tag", "onCreate")
        Toast.makeText(this, "onCreate()호출", Toast.LENGTH_SHORT).show()
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
        Log.d("${tag}", "onStart")
        //Toast.makeText(this, "onStart()호출", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("${tag}", "reStart")
        //Toast.makeText(this, "onRestart()호출", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("${tag}", "onResume")
        //Toast.makeText(this, "onResume()호출", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("${tag}", "onStop")
        //Toast.makeText(this, "onStop()호출", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("${tag}", "onPause")
        //Toast.makeText(this, "onPause()호출", Toast.LENGTH_SHORT).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("${tag}", "onDestroy")
        //Toast.makeText(this, "onDestroy()호출", Toast.LENGTH_SHORT).show()
    }

}