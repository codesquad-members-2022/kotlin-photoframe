package com.codesquad.kotlinphotoframe


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.lang.Exception
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myTextView = findViewById<TextView>(R.id.main_text)
        myTextView.text = "Stark의 사진액자"
        myTextView.setTextColor(Color.BLUE)
        myTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)

        val button = findViewById<Button>(R.id.main_button)
        button.text = "사진 추가"
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f)
        button.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.main_button -> {
                val imageView = findViewById<ImageView>(R.id.main_image)
                val images = listOf( // Int 로 숫자를 랜덤 생성할 시 01, 02 와 같이 앞에 0을 구현하기 힘들어서 String 리스트로 처리
                    "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                    "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22"
                )
                val randomIdx = Random.nextInt(images.size)
                val image = images[randomIdx]
                try {
                    val assetManager = resources.assets
                    val inputStream = assetManager.open("Demo Images/$image.jpg")
                    val bitmap: Bitmap = BitmapFactory.decodeStream(inputStream)
                    imageView.setImageBitmap(bitmap)
                } catch (e: Exception) {
                    e.message
                }
            }
        }
    }
}