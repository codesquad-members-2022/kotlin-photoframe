package com.codesquad.kotlinphotoframe

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val const_layout = findViewById<ConstraintLayout>(R.id.const_layout)

        val myTextView = findViewById<TextView>(R.id.mainText) // UI 요소를 사용 시 보통 lateinit 을 사용해 객체를 선언하면 좋다.
        myTextView.text = "Stark의 사진액자"
        myTextView.setTextColor(Color.BLUE) // 텍스트 색깔이나 사이즈를 xml 이 아니라 틀린 코드에서 동적으로 처리하는 이유?
        myTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)

        val button = findViewById<Button>(R.id.main_button)
        button.text = "사진 추가"
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f)

        val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val message = result.data?.getStringExtra("message").toString()
                Snackbar.make(const_layout, message, Snackbar.LENGTH_LONG).show()
            }
        }

        button.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            getResult.launch(intent)
        }
    }
}