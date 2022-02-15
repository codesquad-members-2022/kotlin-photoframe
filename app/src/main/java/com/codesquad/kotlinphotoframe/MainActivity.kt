package com.codesquad.kotlinphotoframe

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate")


        //TextView 생성 후 코드 참조
        val textForFrame: TextView = findViewById(R.id.textForFrame)
        setTextForFrame(textForFrame)

        // 첫번째 button 생성 후 코드 참조
        val button: Button = findViewById(R.id.button)
        setButtonFirst(button)

        // 두번째 button 생성 후 클릭하면 다음 activity로 전환
        val button2: Button = findViewById(R.id.button2)
        val launcher = showTextAfterotherActivity(button2)
        button2.setOnClickListener {
            val intent= Intent(this, SecondActivity::class.java)
            launcher.launch(intent)
        }
    }


    private fun setTextForFrame(textForFrame: TextView) {
        val name = "Linus"
        textForFrame.text = "${name}의 사진액자"
        textForFrame.setTextColor(Color.parseColor("#FF0000"))
        textForFrame.setBackgroundColor(Color.YELLOW)
        textForFrame.setTextSize(5,8.0f)
    }

    private fun setButtonFirst(button: Button) {
        val textForbutton = "사진 추가"
        button.text = "$textForbutton"
        button.setOnClickListener {
            Snackbar.make(it, "사진을 불러옵니다", LENGTH_SHORT).setAction("Okay") {
                Toast.makeText(this, "Toast 먹고싶다", Toast.LENGTH_SHORT).show()
            }.show()
        }
    }

    private fun showTextAfterotherActivity(view: View): ActivityResultLauncher<Intent> {
        return registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            Snackbar.make(view, "사진을 불러왔습니다", LENGTH_SHORT).show()
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
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

