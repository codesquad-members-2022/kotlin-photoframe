package com.codesquad.kotlinphotoframe

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class targetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target)
        var prevBtn= findViewById<Button>(R.id.target_btn_close)
        Log.d("targetActivitiy","onCreate")
        prevBtn.setOnClickListener{
            var intent= intent
            intent.putExtra("message","사진을 불러왔습니다")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("targetActivity","onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d("targetActivity","onStop")
        //Toast.makeText(this,"onStop()호출",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("targetActivity","onPause")
        //Toast.makeText(this,"onPause()호출",Toast.LENGTH_SHORT).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("targetActivity","onDestroy")
        //Toast.makeText(this,"onDestroy()호출",Toast.LENGTH_SHORT).show()
    }


}