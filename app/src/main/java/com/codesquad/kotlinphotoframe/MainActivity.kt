package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    var change = true

    private lateinit var tv1 : TextView
    private lateinit var btn_change_tv1 : Button
    private lateinit var btn_add_photo : Button
    private lateinit var btn_goto_second_activity : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("logTest", "$this - onCreate")

        tv1 = findViewById<TextView>(R.id.tv1)
        tv1.text = "Han의 사진 액자"

        setTextViewChangeButton()
        setAddPhotoButton()
        setGotoSecondActivityButton()

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

    fun setGotoSecondActivityButton(){
        val getActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == 1004){
                var data = it.data?.getStringExtra("data")
                Toast.makeText(this, "사진을 불러왔습니다\n data : $data", Toast.LENGTH_SHORT).show()
            }
        }

        btn_goto_second_activity = findViewById(R.id.btn_goto_second_activity)
        btn_goto_second_activity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            getActivityResult.launch(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("logTest", "$this - onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.d("logTest", "$this - onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("logTest", "$this - onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("logTest", "$this - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("logTest", "$this - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("logTest", "$this - onDestroy")
    }

}

