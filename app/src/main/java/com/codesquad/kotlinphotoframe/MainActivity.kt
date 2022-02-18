package com.codesquad.kotlinphotoframe

import android.content.Intent
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
    private lateinit var btnChangeTv1 : Button
    private lateinit var btnAddPhoto : Button
    private lateinit var btnGotoSecondActivity : Button
    private lateinit var btnGotoThirdActivity : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("logTest", "$this - onCreate")

        tv1 = findViewById<TextView>(R.id.tv1)
        tv1.text = "Han의 사진 액자"

        setTextViewChangeButton()
        setAddPhotoButton()
        setGotoSecondActivityButton()
        setGotoThirdActivityButton()
    }

    fun setTextViewChangeButton(){
        btnChangeTv1 = findViewById(R.id.btn_change_tv1)
        btnChangeTv1.setOnClickListener {
            if(change){
                tv1.apply {
                    text = "CHANGE CLICKED"
                    setTextColor(ContextCompat.getColor(context, R.color.myGreen))
                    setBackgroundResource(R.color.myGray)
                }
                btnChangeTv1.text = "UNDO"
            }
            else{
                tv1.apply {
                    text = "Han의 사진 액자"
                    setTextColor(ContextCompat.getColor(context, R.color.black))
                    setBackgroundColor(ContextCompat.getColor(context, R.color.white))
                }
                btnChangeTv1.text = "CHANGE"
            }
            change = !change
        }
    }

    fun setAddPhotoButton(){
        btnAddPhoto = findViewById(R.id.btn_add_photo)
        btnAddPhoto.setOnClickListener {
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

        btnGotoSecondActivity = findViewById(R.id.btn_goto_second_activity)
        btnGotoSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            getActivityResult.launch(intent)
        }
    }

    fun setGotoThirdActivityButton(){
        val getActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        }
        btnGotoThirdActivity = findViewById(R.id.btn_goto_third_activity)
        btnGotoThirdActivity.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
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

