package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.codesquad.kotlinphotoframe.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Log.d("logTest", "$this - onCreate")

        setCloseBtn()
    }

    fun setCloseBtn(){
        binding.btnClose.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("data", "데이터 전달 성공")
            setResult(1004, intent)
            finish()

            /*
            setResult(1004)
            finish()
            */
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